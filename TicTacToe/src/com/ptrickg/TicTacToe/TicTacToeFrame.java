package com.ptrickg.TicTacToe;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;



public class TicTacToeFrame extends JFrame {
	
	// Whos turn
	private char whoTurn = 'X';
			
	// Play grid
	// creating Grid within Grid array 3 x 3
	private Grid[][] grid = new Grid[3][3];
			
	// labeling panel
	JLabel lStatus = new JLabel("X's turn");

	public TicTacToeFrame() {
		
		// Game frame
		JPanel panel = new JPanel(new GridLayout(3 , 3, 0, 0));
		
		// loop to add each Grid
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				panel.add(grid[i][j] = new Grid());
				
			}
		}
		
		// set and pop game
		panel.setBorder(new LineBorder(Color.blue, 50));
		lStatus.setBorder(new LineBorder(Color.red, 10));
		
		add(panel, BorderLayout.CENTER);
		add(lStatus, BorderLayout.SOUTH);
		
		
		
	}
	
	public boolean isPlayed() {
		
		/**
		 * go through and check what boxes have been played
		 * keep looping until all have been
		 */
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j].getPlay() == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isWon(char cp) {
		
		/**
		 * go through and check input for all grids
		 */
		// rows
		for (int i = 0; i < 3; i++) {
			if ((grid[i][0].getPlay() == cp)
				&& (grid[i][1].getPlay() == cp)
				&& (grid[i][2].getPlay() == cp)) {
					
				return true;
			}
		}
		
		// columns
		for (int j = 0; j < 3; j++) {
			if ((grid[0][j].getPlay() == cp)
				&& (grid[1][j].getPlay() == cp)
				&& (grid[2][j].getPlay() == cp)) {
					
				return true;
			}
		}
		
		// diag 1
		if ((grid[0][0].getPlay() == cp)
			&& (grid[1][1].getPlay() == cp)
			&& (grid[2][2].getPlay() == cp)) {
					
				return true;
		}
		
		// diag 2
		if ((grid[0][2].getPlay() == cp)
				&& (grid[1][1].getPlay() == cp)
				&& (grid[2][0].getPlay() == cp)) {
						
					return true;
			}
		return false;
	}
	
	/**
	 * Create input grid
	 *
	 */
	
	public class Grid extends JPanel {
		
		private char play = ' ';
		

		public Grid() {
			
			setBorder(new LineBorder(Color.DARK_GRAY, 5));
			addMouseListener(new MouseListener());
		}
		
		public char getPlay() {
			
			return play;
			
		}
		
		public void setPlay(char c) {
			
			play = c;
			repaint();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			if (play == 'X') {
				g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
				g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
			}
			else if (play == 'O') {
				g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
			}
			
			
		}
		
		/**
		 * 
		 * Listening for input
		 */
		
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
}
	

	
