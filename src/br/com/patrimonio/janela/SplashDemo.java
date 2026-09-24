package br.com.patrimonio.janela;

import java.awt.SplashScreen;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class SplashDemo {
    protected JFrame loaderFrame;
    protected JLabel icon;
    protected JLabel status;
    protected JProgressBar progressBar;

    public static void main(String args[]) {
    	
    }
    
    
    /**
     * Initiates a new Splash Screen
     * @see SplashScreen (ImageIcon, String)
     * @param icon The Icon to be displayed on the Splash Screen
     */
    public SplashDemo(ImageIcon icon) {
        this(icon, "");
    }

    /**
     * @param icon The Icon to be displayed on the Splash Screen
     * @param status The initial status text to be displayed.
     */
    public SplashDemo(ImageIcon icon, String status) {
        assert icon != null : "icon must not be null!";
        assert status != null : "status must not be null!";

        loaderFrame = new JFrame();
        loaderFrame.setLayout(new BoxLayout(loaderFrame.getContentPane(), BoxLayout.Y_AXIS));

        this.icon = new JLabel(icon);
        loaderFrame.add(this.icon);

        this.status = new JLabel(status);
        loaderFrame.add(this.status);

        progressBar = new JProgressBar(0, 100);
        loaderFrame.add(progressBar);

        loaderFrame.setUndecorated(true);
        loaderFrame.setSize(icon.getIconWidth(), icon.getIconHeight() + 30);
    }

    /**
     * Centers the Splash Screen and then shows it.
     */
    public void show() {
        loaderFrame.setLocationRelativeTo(null);
        loaderFrame.setVisible(true);
    }

    /**
     * Set the value of progressbar on the Splash Screen
     * @param progress The value to be set
     */
    public void setProgress(int progress) {
        progressBar.setValue(progress);
    }

    /**
     * Returns the actual value of the progressbar on the Splash Screen
     * @return The actual Value of the progressbar
     */
    public int getProgress() {
        return progressBar.getValue();
    }

    /**
     * Sets a new status text
     * @param status The new status text
     */
    public void setStatus(String status) {
        this.status.setText(status);
    }

    /**
     * Sets the progressbar to intedeterminate, waits a second and disposes the Splash Screen.
     */
    public void finishLoading() {
        try {
            progressBar.setIndeterminate(true);
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loaderFrame.dispose();
    }

    /**
     * Set the minimum Value of the Progress Bar
     * @param min The minimum Value of the Progress Bar
     */
    public void setMinimum(int min) {
        progressBar.setMinimum(min);
    }

    /**
     * Set the maximum Value of the Progress Bar
     * @param max The maximum Value of the Progress Bar
     */
    public void setMaximum(int max) {
        progressBar.setMaximum(max);
    }

    /**
     * Returns the actual minimum value of the Progress Bar on the Splash Screen
     * @return the minimum value
     */
    public int getMinimum() {
        return progressBar.getMinimum();
    }

    /**
     * Returns the actual maximum value of the Progress Bar on the Splash Screen
     * @return the maximum value
     */
    public int getMaximum() {
        return progressBar.getMaximum();
    }

    /**
     * Gets the actual status text of the Splash Screen
     * @return the status text
     */
    public String getStatus() {
        return status.getText();
    }

    /**
     * Gets the actual icon of the Splash Screen
     * @return the icon
     */
    public Icon getIcon() {
        return icon.getIcon();
    }

    /**
     * Sets a new icon to the Splash Screen
     * @param icon the new icon
     */
    public void setIcon(Icon icon) {
        this.icon.setIcon(icon);
    }
}