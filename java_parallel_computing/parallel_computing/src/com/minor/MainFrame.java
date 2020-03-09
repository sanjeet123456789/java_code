package com.minor;

import java.awt.BorderLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;



public class MainFrame extends JFrame implements ButtonListener{

	private static final long serialVersionUID = 1L;
	private Tool_Layout toolbar;
	private Board board;
	private ExecutorService layersExecutor;
	private ExecutorService sweepersExecutor;
	private MineLayer[] mineLayers;
	private MineSweeper[] mineSweepers;
	
	public MainFrame(){
		super(Constants.FRAME_NAME);
		
		toolbar = new Tool_Layout();
		board = new Board();
		
		initializeVariables();
				
		toolbar.setButtonListener(this);
		
		add(toolbar, BorderLayout.NORTH);
		add(board, BorderLayout.CENTER);
		
		setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initializeVariables() {
		mineLayers = new MineLayer[Constants.LAYERS];
		mineSweepers = new MineSweeper[Constants.SWEEPERS];
	}

	@Override
	public void startClicked() {
		
		this.layersExecutor = Executors.newFixedThreadPool(Constants.LAYERS);
		this.sweepersExecutor = Executors.newFixedThreadPool(Constants.SWEEPERS);
	
		try{
			
			for(int i=0;i<Constants.LAYERS;i++){
				mineLayers[i] = new MineLayer(i, board);
				layersExecutor.execute(mineLayers[i]);
			}
			
			for(int i=0;i<Constants.SWEEPERS;i++){
				mineSweepers[i] = new MineSweeper(i, board);
				sweepersExecutor.execute(mineSweepers[i]);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			layersExecutor.shutdown();
			sweepersExecutor.shutdown();
		}		
	}

	@Override
	public void stopClicked() {
		
		for(MineLayer mineLayer : this.mineLayers){
			mineLayer.setLayerRunning(false);
		}
		
		for(MineSweeper mineSweeper : this.mineSweepers){
			mineSweeper.setSweeperRunning(false);
		}
		
		layersExecutor.shutdown();
		sweepersExecutor.shutdown();
		
		try {
			layersExecutor.awaitTermination(1, TimeUnit.MINUTES);
			sweepersExecutor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		layersExecutor.shutdownNow();
		sweepersExecutor.shutdownNow();
		
		this.board.clearBoard();
		
	}
}
