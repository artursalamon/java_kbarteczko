package gui.set01.zadanie06_2;

import javax.swing.*;
import java.awt.*;

/**
 * Panel
 *
 * @author s8376
 */
public class Panel extends JPanel {

	Color color = Color.blue;
	String title;
	int counter,
			lineWidth = 10,
			lineHeight = 10,
			margin = 10,
			lineMargin = 30,
			rectMaxSize = 310;

	/**
	 * @param g
	 */
	public void paintComponent(Graphics g) {

		g.setColor(color);
		g.drawString(title, margin, lineHeight);
		g.fillRect(lineMargin, 0, lineWidth, lineHeight);
		g.drawString("" + counter, lineMargin + lineWidth + margin, lineHeight);
	}

	/**
	 * @param lineWidth
	 */
	public void setLineWidth(int lineWidth) {
		this.lineWidth = (int) (rectMaxSize * 0.01 * lineWidth) + margin;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public int getLineHeight() {
		return lineHeight;
	}

	public void setLineHeight(int lineHeight) {
		this.lineHeight = lineHeight;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public int getLineMargin() {
		return lineMargin;
	}

	public void setLineMargin(int lineMargin) {
		this.lineMargin = lineMargin;
	}

	public int getRectMaxSize() {
		return rectMaxSize;
	}

	public void setRectMaxSize(int rectMaxSize) {
		this.rectMaxSize = rectMaxSize;
	}
}
