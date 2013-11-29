package game.graphics.swing;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Create the dialog.
     */
    public HelpDialog() {
        setTitle("Help");
        setBounds(120, 120, 350, 260);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        {
            JTextArea infoTextArea = new JTextArea();
            infoTextArea.setLineWrap(true);
            infoTextArea.setWrapStyleWord(true);
            // @formatter:off
            infoTextArea
                    .setText("The aim of the game is to lead the fox to the opposite end of the gameboard. " +
                    		"You can't enter a field occupied by a hound. If a fox is in a situation " +
                    		"that disallows it to perform a movement, hounds win." +
                    		"\r\n\r\n" +
                    		"Controls:" +
                    		"\r\n1 - go down-left" +
                    		"\r\n3 - go down-right" +
                    		"\r\n7 - go up-left" +
                    		"\r\n9 - go up-right" +
                    		"\r\n\r\n" +
                    		"The game gives the best expirience when played on numerical keyboard.");
            // @formatter:on
            contentPanel.add(infoTextArea, BorderLayout.CENTER);
        }
    }

}
