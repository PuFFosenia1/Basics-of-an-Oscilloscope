package ex02_oscilloscope;

import java.awt.Graphics;
import java.awt.*;
import javax.swing.JComponent;

public class SignalGraph extends JComponent{
//--------------
private int scale;
private double frequency;
private double amplitude;
private double wave;
private int color;
double y;
 //

//--------------
public SignalGraph(int s, double f, double a, double w, int c) {
scale = s;
frequency = f;
amplitude = a;
wave = w;
color = c;
}
//--------------

public void grid(Graphics g) {
	int width = getWidth();
	int height = getHeight(); 
	
	g.drawLine(width/2, 0, width/2, height);
	g.drawLine(0, height/2, width, height/2);

	g.setColor(Color.BLACK);
	for (int i=scale; i<height/2; i+=scale) {
	g.drawLine(0, height/2-i, width, height/2-i);
	g.drawLine(0, height/2+i, width, height/2+i);
	}
	for (int i=scale; i<width/2; i+=scale) {
	g.drawLine (width/2-i, 0, width/2-i, height);
	g.drawLine (width/2+i, 0, width/2+i, height);
	}
}
public void paint(Graphics g) {
	int width = getWidth();
	int height = getHeight(); 
	grid(g);
	if(color == 1) {
		g.setColor(Color.cyan);}
	else if(color == 2){
		g.setColor(Color.magenta);
	}else {
		g.setColor(Color.green);
	}

for ( double x = -width/scale; x < width/2/2*scale; x+=0.01) {
	//wave=1;
	
	if(wave == 1.0) {
		y= amplitude * Math.sin(x * Math.PI * frequency);
	}
	else if(wave == 2.0){
		y = (2*amplitude)/Math.PI * Math.asin(Math.sin(x * Math.PI * frequency));
	}else {
		y = amplitude *Math.signum(Math.sin(x * Math.PI * frequency));
	}
//System.out.println(wave);

int px = (int) (width/2 + x*scale);
int py = (int) (height/2 - y*scale);

drawCircle(g,px, py,2);
}}
private void drawCircle(Graphics g, int x, int y, int radius) {
	g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
}

//-------------
public void setScale(int s) {
scale = s;
repaint();
}
//-------------
public void setFrequency(double f) {
frequency = f;
repaint();
}
//-------------
public void setAmplitude(double a) {
amplitude = a;
repaint();
}
//-------------
public void setWave(double w) {
wave = w;
repaint();
}
public int getScale() {
return scale;
}
//-------------
public double getFrequency() {
return frequency;
}
//-------------
public double getAmplitude() {
return amplitude;
}

public double getWave() {
return wave;
}}
