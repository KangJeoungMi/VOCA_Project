package Cutomer;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class CustomTextField extends JTextField {
	  private String hintText = ""; // 힌트 텍스트
	    private Color underlineColor = new Color(254, 197, 116); // 밑줄 색상
	    private int underlineThickness = 2; // 밑줄 굵기

	    public CustomTextField(String hintText) {
	        this.hintText = hintText;
	        setCaretColor(Color.BLACK); // 캐럿 색상

	        // 포커스 이벤트 처리
	        addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                repaint(); // 컴포넌트 다시 그리기
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                repaint(); // 컴포넌트 다시 그리기
	            }
	        });
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        // 그래픽스 객체 변환
	        Graphics2D g2d = (Graphics2D) g.create();
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	        // 힌트 텍스트 그리기
	        if (getText().isEmpty() && !hasFocus()) {
	            g2d.setColor(Color.GRAY);
	            g2d.drawString(hintText, getInsets().left, getHeight() / 2 + getFontMetrics(getFont()).getAscent() / 2);
	        }

	        // 밑줄 그리기
	        if (hasFocus()) {
	            g2d.setColor(underlineColor);
	            g2d.fillRect(0, getHeight() - underlineThickness, getWidth(), underlineThickness);
	        }

	        // 그래픽스 객체 리소스 반환
	        g2d.dispose();
	    }
	}