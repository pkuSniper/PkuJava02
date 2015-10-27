package com.pku.ding.wuziqi;
import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;
	//对水平方向计数
	private int horizonCount = -1;
	//对垂直方向计数
	private int verticalCount = -1;
	//对左对角线记数
	private int leftDiagonalCount = -1;
	private int leftBeginX = -1;
	private int leftBeginY = -1;
	//对右对角线记数
	private int rightDiagonalCount = -1;
	private int rightBeginX = -1;
	private int rightBeginY = -1;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int[] result = { posX, posY };
		if(horizonCount != -1)
		{
			result[0] = chessboard.lastX;
			result[1] = horizonCount;
			horizonCount = -1;
			return result;
		}
		if(verticalCount != -1)
		{
			result[0] = verticalCount;
			result[1] = chessboard.lastY;
			verticalCount = -1;
			return result;
		}
		if(leftDiagonalCount != -1)
		{
			result[0] = leftBeginX + leftDiagonalCount;
			result[1] = leftBeginY + leftDiagonalCount;
			leftDiagonalCount = -1;
			return result;
		}
		if(rightDiagonalCount != -1)
		{
			posX = rightBeginX + rightDiagonalCount;
			posY = rightBeginY - rightDiagonalCount;
			rightDiagonalCount = -1;
			return result;
		}
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
				posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
				posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		result[0] = posX;
		result[1] = posY;
		return result;
	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @param flag
	 * 			       五个棋子类型的匹配串
	 * @param horizon 
	 * 				水平方向的字符模版串
	 * 	依次类推		 
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		String[][] boardWon = chessboard.getBoard();
		String flag = ico + ico + ico + ico + ico;
		String horizon = "";
		String vertical = "";
		String leftDiagonal = "";
		String rightDiagonal = "";
		int beginX = posX;
		int beginY = 0;
		//判断水平是否五子相连
		while(beginY != Chessboard.BOARD_SIZE)
		{
			horizon+=boardWon[posX][beginY];
			beginY++;
		}
		horizonCount = scoreBoard(horizon,ico,horizonCount);
		if(horizon.contains(flag))
			return true;
		//判断垂直是否五子相连
		beginX = 0;
		beginY = posY;
		while(beginX != Chessboard.BOARD_SIZE)
		{
			vertical+= boardWon[beginX][posY];
			beginX++;
		}
		verticalCount = scoreBoard(vertical,ico,verticalCount);
		if(vertical.contains(flag))
			return true;
		//判断左对角线是否五子相连
		if(posX < posY)
		{
			beginX = 0;
			beginY = posY - posX;
		}
		else
		{
			beginY = 0;
			beginX = posX - posY;
		}
		leftBeginX = beginX;
		leftBeginY = beginY;
		while(beginX != Chessboard.BOARD_SIZE 
				&& beginY != Chessboard.BOARD_SIZE)
		{
			leftDiagonal+= boardWon[beginX][beginY];
			beginX++;
			beginY++;
		}
		leftDiagonalCount = scoreBoard(leftDiagonal,ico,leftDiagonalCount);
		if(leftDiagonal.contains(flag))
			return true;
		beginX = posX;
		beginY = posY;
		//判断右对角线是否相连
		while(beginX != 0)
		{
			if(beginY == Chessboard.BOARD_SIZE - 1)
				break;
			beginX--;
			beginY++;
		}
		rightBeginX = beginX;
		rightBeginY = beginY;
		while(beginX != Chessboard.BOARD_SIZE
				&& beginY != -1)
		{
			rightDiagonal+= boardWon[beginX][beginY];
			beginX++;
			beginY--;
		}
		rightDiagonalCount = scoreBoard(rightDiagonal,ico,rightDiagonalCount);
		if(rightDiagonal.contains(flag))
			return true;
		return false;
	}
	/**
	 * 对形势进行打分
	 * @param boardLine
	 * @return
	 */
	public int scoreBoard(String boardLine,String ico,int flag)
	{
		
		String sub1 = ico + ico + "十" + ico + ico;
		String sub2 = ico + ico + ico + ico + "十";
		String sub3 = "十" + ico + ico + ico + ico;
		String sub4 = "十" + ico +ico + ico + "十";
		String sub5 = "十" + ico +ico + ico;
		String sub6 = ico +ico + ico + "十";
		
		if(boardLine.contains(sub6))
		{
			System.out.println("聪明的人类已经●●●十了，危险系数6.0.还不堵住他!");
			flag = boardLine.indexOf(sub6) + 3;
			return flag;
		}
		if(boardLine.contains(sub5))
		{
			System.out.println("聪明的人类已经十●●●了，危险系数6.0.还不堵住他!");
			flag = boardLine.indexOf(sub5);
			return flag;
		}
		if(boardLine.contains(sub4))
		{
			System.out.println("聪明的人类已经十●●●十了，危险系数6.0.还不堵住他!");
			flag = boardLine.indexOf(sub4);
			return flag;
		}
		if(boardLine.contains(sub1))
		{
			System.out.println("聪明的人类已经●●十●●了，危险系数9.0.还不堵住他!");
			flag = boardLine.indexOf(sub1) + 2;	
			return flag;
		}
		if(boardLine.contains(sub2))
		{
			System.out.println("聪明的人类已经●●●●十了，危险系数9.0.还不堵住他!");
			flag = boardLine.indexOf(sub2) + 4;
			return flag;
		}
		if(boardLine.contains(sub3))
		{
			System.out.println("聪明的人类已经十●●●●了，危险系数9.0.还不堵住他!");
			flag = boardLine.indexOf(sub3);
			return flag;
		}
		return flag;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
