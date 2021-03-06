package game.graphics.swing;

import game.graphics.SwingDrawer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class SwingGameBoard {

    private JFrame foxAndHoundsFrame;
    private JTextField messagesTextField;
    private GameCanvas gameCanvas;
    private SwingDrawer swingDrawer;
    HelpDialog helpDialog;

    private int gamePanelWidth = 200;
    private int gamePanelHeight = 200;

    private int gameCanvasMarign = 5;

    /**
     * Launch the application.
     */
    public void display() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    foxAndHoundsFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SwingGameBoard(SwingDrawer swingDrawer) {
        this.swingDrawer = swingDrawer;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        helpDialog = new HelpDialog();
        helpDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        foxAndHoundsFrame = new JFrame();
        foxAndHoundsFrame.setTitle("Fox and Hounds");
        foxAndHoundsFrame.setBounds(100, 100, 420, 485);
        foxAndHoundsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        foxAndHoundsFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                swingDrawer.keyPressed(e);
            }
        });

        gameCanvas = new GameCanvas();
        {
            JMenuBar menuBar = new JMenuBar();
            foxAndHoundsFrame.getContentPane().add(menuBar, BorderLayout.NORTH);

            {
                JMenu gameMenu = new JMenu("Game");
                menuBar.add(gameMenu);
                {
                    JMenuItem resetMenuItem = new JMenuItem("Reset");
                    resetMenuItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            swingDrawer.resetGame();
                        }
                    });
                    gameMenu.add(resetMenuItem);

                    JMenuItem exitMenuItem = new JMenuItem("Exit");
                    exitMenuItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            foxAndHoundsFrame.dispatchEvent(new WindowEvent(foxAndHoundsFrame,
                                    WindowEvent.WINDOW_CLOSING));
                        }
                    });
                    gameMenu.add(exitMenuItem);
                }

                JMenu helpMenu = new JMenu("Help");
                menuBar.add(helpMenu);
                {
                    JMenuItem helpMenuItem = new JMenuItem("Help");
                    helpMenuItem.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!helpDialog.isVisible()) {
                                helpDialog.setVisible(true);
                            }
                        }
                    });
                    helpMenu.add(helpMenuItem);
                }
            }

            JPanel gameMainPanel = new JPanel();
            foxAndHoundsFrame.getContentPane().add(gameMainPanel, BorderLayout.WEST);
            {
                gameCanvas = new GameCanvas();
                gameCanvas.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
                gameCanvas.setPreferredSize();
                gameMainPanel.add(gameCanvas);
            }

            messagesTextField = new JTextField();
            messagesTextField.setEnabled(false);
            messagesTextField.setBackground(new Color(255, 255, 255));
            foxAndHoundsFrame.getContentPane().add(messagesTextField, BorderLayout.SOUTH);
            messagesTextField.setColumns(10);
            messagesTextField.setDisabledTextColor(Color.BLACK);
        }
    }

    public void displayMessage(String message) {
        messagesTextField.setText(message);
    }

    public GameCanvas getGameCanvas() {
        return gameCanvas;
    }

}
