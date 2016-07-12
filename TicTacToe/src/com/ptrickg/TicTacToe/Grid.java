package com.ptrickg.TicTacToe;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.border.LineBorder;

public class Grid {
	
	private char play = ' ';
	

	public Grid() {
		
		setBorder(new LineBorder(Color.DARK_GRAY, 1));
		setMouseListener(new MouseListener());
	}
	
	public char getPlay() {
		
		return play;
		
	}
	
	public void setPlay(char c) {
		
		play = c;
		repaint();
	}
	
	@Override
	protected void paintComp(Graphics g) {
		
		super.paintComp(g);
		
		if (play == 'X') {
			g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
			g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
		}
		else if (play == 'O') {
			g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
		}
		
		
	}
	
	private class MouseListener extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if (play == ' ' && whoTurn != ' ') {
				setPlay(whoTurn);
			}
			
			if (isWon(whoTurn)) {
				
				lStatus.setText(whoTurn + " Win! Game Over.");
				whoTurn = ' ';
				
			}
			else if (isPlayed()) {
				
				lStatus.setText("Tie! Game Over.");
				whoTurn = ' ';
			}
			
			else {
				
				whoTurn = (whoTurn == 'X') ? 'O' : 'X';
				lStatus.setText(whoTurn + "'s turn.");
			}
		}
	}
	

}
