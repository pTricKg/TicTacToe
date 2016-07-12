/**
 * 
 */
package com.ptrickg.TicTacToe;

import javax.swing.JFrame;

/**
 * @author ptrickg
 *
 */
public class TicTacToe {

	/**
	 * 
	 */
	public TicTacToe() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame ticTacToe = new TicTacToeFrame();
		ticTacToe.setTitle("pTricKg's Tic Tac Toe!!");
		ticTacToe.setSize(400, 400);
		ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ticTacToe.setLocationRelativeTo(null);
		ticTacToe.setVisible(true);

	}

}
