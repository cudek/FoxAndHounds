package game.graphics.swing;

import game.graphics.SwingDrawer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        foxAndHoundsFrame = new JFrame();
        foxAndHoundsFrame.setTitle("Fox and Hounds");
        foxAndHoundsFrame.setBounds(100, 100, 500, 500);
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
                    gameMenu.add(resetMenuItem);

                    JMenuItem exitMenuItem = new JMenuItem("Exit");
                    gameMenu.add(exitMenuItem);
                }

                JMenu helpMenu = new JMenu("Help");
                menuBar.add(helpMenu);
                {
                    JMenuItem helpMenuItem = new JMenuItem("Help");
                    helpMenu.add(helpMenuItem);
                }
            }

            JPanel gameMainPanel = new JPanel();
            foxAndHoundsFrame.getContentPane().add(gameMainPanel, BorderLayout.WEST);
            {
                gameCanvas = new GameCanvas();
                gameCanvas.setBorder(new LineBorder(Color.BLACK, 3));
                gameCanvas.setPreferredSize();
                gameMainPanel.add(gameCanvas);
            }

            messagesTextField = new JTextField();
            messagesTextField.setEnabled(false);
            messagesTextField.setBackground(new Color(255, 255, 255));
            foxAndHoundsFrame.getContentPane().add(messagesTextField, BorderLayout.SOUTH);
            messagesTextField.setColumns(10);
        }
    }

    public GameCanvas getGameCanvas() {
        return gameCanvas;
    }

}
