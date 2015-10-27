import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 1;
	// 定义用户输入的X坐标
	private int posY = 1;
	// 定义棋盘
	private Chessboard chessboard;

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
			posX = Integer.parseInt(posStrArr[0]);
			posY = Integer.parseInt(posStrArr[1]);
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 1 || posX > Chessboard.BOARD_SIZE-1 || posY < 1
				|| posY > Chessboard.BOARD_SIZE-1) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于15,请重新输入：");
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
				int[] computerPosArr = computerDo(chessman);
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
				else	
					break;
			}
			chessboard.printBoard();
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
	 * 计算机下棋，以防守为主的简单策略，当检测到对手三子连棋，优先围堵；其次是对手二子连棋，进行围堵；
	 * 如果没有以上情况，则进攻。
	 */
	public int[] computerDo(String ico) throws Exception{
		
		String[][] board = chessboard.getBoard();
		int i, j, m=1, n=1, max=-1, flag=0;
		int posX=1, posY=1, c=0;
		for(i=1; i<=Chessboard.BOARD_SIZE-1; i++) {
			for(j=1; j<=Chessboard.BOARD_SIZE-1; j++) {
				int count = 0;
				if(board[i][j] == "十") {
					if(i>=4)
						if(board[i-1][j].equals(ico)&&board[i-2][j].equals(ico)&&board[i-3][j].equals(ico))
							count++;
					if(i<=12)
						if(board[i+1][j].equals(ico)&&board[i+2][j].equals(ico)&&board[i+3][j].equals(ico))
							count++;
					if(j>=4)
						if(board[i][j-1].equals(ico)&&board[i][j-2].equals(ico)&&board[i][j-3].equals(ico))
							count++;
					if(j<=12)
						if(board[i][j+1].equals(ico)&&board[i][j+2].equals(ico)&&board[i][j+3].equals(ico))
							count++;
					if(i>=4&&j>=4)
						if(board[i-1][j-1].equals(ico)&&board[i-2][j-2].equals(ico)&&board[i-3][j-3].equals(ico))
							count++;
					if(i<=12&&j<=12)
						if(board[i+1][j+1].equals(ico)&&board[i+2][j+2].equals(ico)&&board[i+3][j+3].equals(ico))
							count++;
					if(i>=4&&j<=12)
						if(board[i-1][j+1].equals(ico)&&board[i-2][j+2].equals(ico)&&board[i-3][j+3].equals(ico))
							count++;
					if(i<=12&&j>=4)
						if(board[i+1][j-1].equals(ico)&&board[i+2][j-2].equals(ico)&&board[i+3][j-3].equals(ico))
							count++;
					if(count>=1&&count>max) {
						m = i;
						n = j;
						max = count;
						flag = 1;
					}
				}
			}
		}
		if(flag==1) {
			posX = m;
			posY = n;
		}
		else {
			max = -1; m = 1; n = 1;
			for(i=1; i<=Chessboard.BOARD_SIZE-1; i++) {
				for(j=1; j<=Chessboard.BOARD_SIZE-1; j++) {
					int count=0;
					if(board[i][j] == "十") {
						if(i>=3)
							if(board[i-1][j].equals(ico)&&board[i-1][j].equals(ico)) count++;
						if(i<=13)
							if(board[i+1][j].equals(ico)&&board[i+2][j].equals(ico)) count++;
						if(j>=3)
							if(board[i][j-1].equals(ico)&&board[i][j-2].equals(ico)) count++;
						if(j<=13)
							if(board[i][j+1].equals(ico)&&board[i][j+2].equals(ico)) count++;
						if(i>=3&&j>=3)
							if(board[i-1][j-1].equals(ico)&&board[i-2][j-2].equals(ico)) count++;
						if(i<=13&&j<=13)
							if(board[i+1][j+1].equals(ico)&&board[i+2][j+2].equals(ico)) count++;
						if(i>=3&&j<=13)
							if(board[i-1][j+1].equals(ico)&&board[i-2][j+2].equals(ico)) count++;
						if(i<=13&&j>=3)
							if(board[i+1][j-1].equals(ico)&&board[i+2][j-2].equals(ico)) count++;
						if(count>=1&&count>max) {
							m = i;
							n = j;
							max = count;
							flag = 2;
						}
					}
				}
			}
		}
		if(flag==2) {
			posX = m;
			posY = n;
		}
		if(flag==0) {
			max = -1; m = 1; n = 1;
			ico = Chessman.WHITE.getChessman();
			for(i=1; i<=Chessboard.BOARD_SIZE-1; i++) {
				for(j=1; j<=Chessboard.BOARD_SIZE-1; j++) {
					int count=0;
					if(board[i][j] == "十") {
						if(i>=3)
							if(board[i-1][j].equals(ico)&&board[i-1][j].equals(ico)) count++;
						if(i<=13)
							if(board[i+1][j].equals(ico)&&board[i+2][j].equals(ico)) count++;
						if(j>=3)
							if(board[i][j-1].equals(ico)&&board[i][j-2].equals(ico)) count++;
						if(j<=13)
							if(board[i][j+1].equals(ico)&&board[i][j+2].equals(ico)) count++;
						if(i>=3&&j>=3)
							if(board[i-1][j-1].equals(ico)&&board[i-2][j-2].equals(ico)) count++;
						if(i<=13&&j<=13)
							if(board[i+1][j+1].equals(ico)&&board[i+2][j+2].equals(ico)) count++;
						if(i>=3&&j<=13)
							if(board[i-1][j+1].equals(ico)&&board[i-2][j+2].equals(ico)) count++;
						if(i<=13&&j>=3)
							if(board[i+1][j-1].equals(ico)&&board[i+2][j-2].equals(ico)) count++;
						if(count>max) {
							m = i;
							n = j;
							max = count;
						}
					}
				}
			}
			posX = m;
			posY = n;
		}
		
		int[] result = { posX, posY };
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
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) throws Exception{
		
		int i, j;
		String[][] board = chessboard.getBoard();
		
		int left = cmp1(1, posX-4);
		left = posX - left;
		int right = cmp2(Chessboard.BOARD_SIZE-1, posX+4);
		right = right - posX;
		int up = cmp1(1, posY-4);
		up = posY - up;
		int down = cmp2(Chessboard.BOARD_SIZE-1, posY+4);
		down = down - posY;
		
		for(i=-left; i<=right-4; i++) {
			for(j=0; j<WIN_COUNT; j++) {
				if(!(board[posX+i+j][posY].equals(ico)))
					break;
			}
			if(j==WIN_COUNT)
				return true;
		}
		
		for(i=-up; i<=down-4; i++) {
			for(j=0; j<WIN_COUNT; j++) {
				if(!(board[posX][posY+i+j].equals(ico)))
					break;
			}
			if(j==WIN_COUNT)
				return true;
		}
		
		for(i=-cmp2(left, up); i<=cmp2(right, down)-4; i++) {
			for(j=0; j<WIN_COUNT; j++) {
				if(!(board[posX+i+j][posY+i+j].equals(ico)))
					break;
			}
			if(j==WIN_COUNT)
				return true;
		}
		
		for(i=-cmp2(left, down); i<=cmp2(right, up)-4; i++) {
			for(j=0; j<WIN_COUNT; j++) {
				if(!(board[posX+i+j][posY-i-j].equals(ico)))
					break;
			}
			if(j==WIN_COUNT)
				return true;
		}
		
		return false;
	}
	
	public int cmp1(int a, int b) {
		if(a > b)
			return a;
		else
			return b;
	}
	
	public int cmp2(int a, int b) {
		if(a < b)
			return a;
		else
			return b;
	}

	public static void main(String[] args) throws Exception {
		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}