package com.pku.ding.wuziqi;
import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;
	//��ˮƽ�������
	private int horizonCount = -1;
	//�Դ�ֱ�������
	private int verticalCount = -1;
	//����Խ��߼���
	private int leftDiagonalCount = -1;
	private int leftBeginX = -1;
	private int leftBeginY = -1;
	//���ҶԽ��߼���
	private int rightDiagonalCount = -1;
	private int rightBeginX = -1;
	private int rightBeginY = -1;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
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
		while (board[posX][posY] != "ʮ") {
				posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
				posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		result[0] = posX;
		result[1] = posY;
		return result;
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @param flag
	 * 			       ����������͵�ƥ�䴮
	 * @param horizon 
	 * 				ˮƽ������ַ�ģ�洮
	 * 	��������		 
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
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
		//�ж�ˮƽ�Ƿ���������
		while(beginY != Chessboard.BOARD_SIZE)
		{
			horizon+=boardWon[posX][beginY];
			beginY++;
		}
		horizonCount = scoreBoard(horizon,ico,horizonCount);
		if(horizon.contains(flag))
			return true;
		//�жϴ�ֱ�Ƿ���������
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
		//�ж���Խ����Ƿ���������
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
		//�ж��ҶԽ����Ƿ�����
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
	 * �����ƽ��д��
	 * @param boardLine
	 * @return
	 */
	public int scoreBoard(String boardLine,String ico,int flag)
	{
		
		String sub1 = ico + ico + "ʮ" + ico + ico;
		String sub2 = ico + ico + ico + ico + "ʮ";
		String sub3 = "ʮ" + ico + ico + ico + ico;
		String sub4 = "ʮ" + ico +ico + ico + "ʮ";
		String sub5 = "ʮ" + ico +ico + ico;
		String sub6 = ico +ico + ico + "ʮ";
		
		if(boardLine.contains(sub6))
		{
			System.out.println("�����������Ѿ�����ʮ�ˣ�Σ��ϵ��6.0.������ס��!");
			flag = boardLine.indexOf(sub6) + 3;
			return flag;
		}
		if(boardLine.contains(sub5))
		{
			System.out.println("�����������Ѿ�ʮ�����ˣ�Σ��ϵ��6.0.������ס��!");
			flag = boardLine.indexOf(sub5);
			return flag;
		}
		if(boardLine.contains(sub4))
		{
			System.out.println("�����������Ѿ�ʮ����ʮ�ˣ�Σ��ϵ��6.0.������ס��!");
			flag = boardLine.indexOf(sub4);
			return flag;
		}
		if(boardLine.contains(sub1))
		{
			System.out.println("�����������Ѿ����ʮ����ˣ�Σ��ϵ��9.0.������ס��!");
			flag = boardLine.indexOf(sub1) + 2;	
			return flag;
		}
		if(boardLine.contains(sub2))
		{
			System.out.println("�����������Ѿ������ʮ�ˣ�Σ��ϵ��9.0.������ס��!");
			flag = boardLine.indexOf(sub2) + 4;
			return flag;
		}
		if(boardLine.contains(sub3))
		{
			System.out.println("�����������Ѿ�ʮ������ˣ�Σ��ϵ��9.0.������ס��!");
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
