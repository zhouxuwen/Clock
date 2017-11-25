package P1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
	private int hour;
	private int minute;
	private int second;
	private double w = 250, h = 250;

	public ClockPane() {
		setCurrentTime();
	}

	public ClockPane(int hour, int minute, int second) {
		this.hour = hour;
		this.second = second;
		this.minute = minute;
		paintClock();
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	private void paintClock() {
		// TODO Auto-generated method stub
		double clockRadius = Math.min(w, h) * 0.4;
		double centerX = w / 2;
		double centerY = h / 2;

		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);

		Text t12 = new Text(centerX - 5, centerY - clockRadius + 20, "12");
		Text t9 = new Text(centerX - clockRadius + 8, centerY + 4, "9");
		Text t3 = new Text(centerX + clockRadius - 16, centerY + 4, "3");
		Text t6 = new Text(centerX - 3, centerY + clockRadius - 10, "6");
		Text t1 = new Text(centerX + clockRadius * Math.sin(Math.PI / 6) - 10,
				centerY - clockRadius * Math.cos(Math.PI / 6) + 15, "1");
		Text t2 = new Text(centerX + clockRadius * Math.sin(Math.PI / 3) - 12,
				centerY - clockRadius * Math.cos(Math.PI / 3) + 12, "2");
		Text t4 = new Text(centerX + clockRadius * Math.sin(Math.PI / 3) - 14,
				centerY + clockRadius * Math.cos(Math.PI / 3) , "4");
		Text t5 = new Text(centerX + clockRadius * Math.sin(Math.PI / 6) - 10,
				centerY + clockRadius * Math.cos(Math.PI / 6) - 6, "5");
		Text t7 = new Text(centerX - clockRadius * Math.sin(Math.PI / 6) + 1,
				centerY + clockRadius * Math.cos(Math.PI / 6) - 4, "7");
		Text t8 = new Text(centerX - clockRadius * Math.sin(Math.PI / 3) + 6,
				centerY + clockRadius * Math.cos(Math.PI / 3) + 0, "8");
		Text t10 = new Text(centerX - clockRadius * Math.sin(Math.PI / 3) + 4,
				centerY - clockRadius * Math.cos(Math.PI / 3) + 10, "10");
		Text t11 = new Text(centerX - clockRadius * Math.sin(Math.PI / 6) - 3,
				centerY - clockRadius * Math.cos(Math.PI / 6) + 16, "11");

		// Draw second hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.BLACK);

		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, xMinute, minuteY);
		mLine.setStroke(Color.RED);

		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);
		
		getChildren().clear();
		getChildren().addAll(circle, t1, t2, t3, t4,t5,t6,t7,t8,t9,t10,t11,t12, sLine, mLine, hLine); 
		
		
		double StartX,StartY,EndX,EndY;
		int j;
		for(int i = 0;i < 60;i ++) {
			EndX = centerX + clockRadius * Math.sin(i * (2 * Math.PI / 60));
			EndY = centerY - clockRadius * Math.cos(i * (2 * Math.PI / 60));
			if(i % 5 == 0) {
				j = 6;
			}
			else {
				j = 2;
			}
			StartX = centerX + (clockRadius - j) * Math.sin(i * (2 * Math.PI / 60));
			StartY = centerY - (clockRadius - j) * Math.cos(i * (2 * Math.PI / 60));
			Line line = new Line(StartX, StartY, EndX, EndY);
			sLine.setStroke(Color.BLACK);
			getChildren().add(line);
		}
		
	}

	public String setCurrentTime() {
		// TODO Auto-generated method stub
		String s = "";
		Calendar calendar = new GregorianCalendar();
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		s = hour + " : " + minute + " : " + second;
		paintClock();
		return s;
	}

}
