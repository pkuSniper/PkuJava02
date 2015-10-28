package five;

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
		/*
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;
		*/
		int posX,posY;
		String[][] board = chessboard.getBoard();
		boolean[] b=new boolean[8];
		for(int i=0;i<b.length;i++){
			b[i]=true;
		}
		for(int i=0;i<Chessboard.BOARD_SIZE;i++){
			for(int j=0;j<Chessboard.BOARD_SIZE;j++){
				if(board[i][j].equals("��")){
					//����
					//8��������ж�
					//1
					for(int k=i,m=j-3;m<j;m++){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[0]=false;
							break;
						}
					  }
					}
					//2
					for(int k=i+3,m=j-3;k>i&&m<j;k--,m++){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[1]=false;
							break;
						}
					   }
					}
					//3
					for(int k=i+3,m=j;k>i;k--){
					 if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[2]=false;
							break;
						}
					 }
					}
					//4
					for(int k=i+3,m=j+3;k>i&&m>j;k--,m--){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[3]=false;
							break;
						}
					  }
					}
					//5
					for(int k=i,m=j+3;m>j;m--){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[4]=false;
							break;
						}
					  }
					}
					//6
					for(int k=i-3,m=j+3;k<i&&m>j;k++,m--){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[5]=false;
							break;
						}
					  }
					}
					//7
					for(int k=i-3,m=j;k<i;i++){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[6]=false;
							break;
						}
					  }
					}
					//8
					for(int k=i-3,m=j-3;k<i&&m<j;k++,m++){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[7]=false;
							break;
						}
					  }
					}
					for(int n=0;n<b.length;n++){
						if(b[n]==true){
							posX=i;posY=j;
							int[] result = { posX, posY };
							return result;
						}
					}
				}
				if(board[i][j].equals("��")){
					//����
					//8��������ж�
					//1
					for(int k=i,m=j-3;m<j;m++){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[0]=false;
							break;
						}
					  }
					}
					//2
					for(int k=i+3,m=j-3;k>i&&m<j;k--,m++){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[1]=false;
							break;
						}
					   }
					}
					//3
					for(int k=i+3,m=j;k>i;k--){
					 if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[2]=false;
							break;
						}
					 }
					}
					//4
					for(int k=i+3,m=j+3;k>i&&m>j;k--,m--){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[3]=false;
							break;
						}
					  }
					}
					//5
					for(int k=i,m=j+3;m>j;m--){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[4]=false;
							break;
						}
					  }
					}
					//6
					for(int k=i-3,m=j+3;k<i&&m>j;k++,m--){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[5]=false;
							break;
						}
					  }
					}
					//7
					for(int k=i-3,m=j;k<i;i++){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[6]=false;
							break;
						}
					  }
					}
					//8
					for(int k=i-3,m=j-3;k<i&&m<j;k++,m++){
					  if(k>=0&&k<chessboard.BOARD_SIZE&&m>=0&&m<chessboard.BOARD_SIZE){
						if(!board[k][m].equals("��")){
							b[7]=false;
							break;
						}
					  }
					}
					for(int n=0;n<b.length;n++){
						if(b[n]==true){
							posX=i;posY=j;
							int[] result = { posX, posY };
							return result;
						}
					}
				}
			}
		}
		posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
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
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		boolean[] b=new boolean[8];
		for(int i=0;i<b.length;i++){
			b[i]=true;
		}
		//8��������ж�
		//1
		for(int i=posX,j=posY-4;j<posY;j++){
		  if(i>=0&&i<chessboard.BOARD_SIZE&&j>=0&&j<chessboard.BOARD_SIZE){
			if(!board[i][j].equals(ico)){
				b[0]=false;
				break;
			}
		  }
		}
		//2
		for(int i=posX+4,j=posY-4;i>posX&&j<posY;i--,j++){
		  if(i>=0&&i<chessboard.BOARD_SIZE&&j>=0&&j<chessboard.BOARD_SIZE){
			if(!board[i][j].equals(ico)){
				b[1]=false;
				break;
			}
		   }
		}
		//3
		for(int i=posX+4,j=posY;i>posX;i--){
		 if(i>=0&&i<chessboard.BOARD_SIZE&&j>=0&&j<chessboard.BOARD_SIZE){
			if(!board[i][j].equals(ico)){
				b[2]=false;
				break;
			}
		 }
		}
		//4
		for(int i=posX+4,j=posY+4;i>posX&&j>posY;i--,j--){
		  if(i>=0&&i<chessboard.BOARD_SIZE&&j>=0&&j<chessboard.BOARD_SIZE){
			if(!board[i][j].equals(ico)){
				b[3]=false;
				break;
			}
		  }
		}
		//5
		for(int i=posX,j=posY+4;j>posY;j--){
		  if(i>=0&&i<chessboard.BOARD_SIZE&&j>=0&&j<chessboard.BOARD_SIZE){
			if(!board[i][j].equals(ico)){
				b[4]=false;
				break;
			}
		  }
		}
		//6
		for(int i=posX-4,j=posY+4;j>posY;i++,j--){
		  if(i>=0&&i<chessboard.BOARD_SIZE&&j>=0&&j<chessboard.BOARD_SIZE){
			if(!board[i][j].equals(ico)){
				b[5]=false;
				break;
			}
		  }
		}
		//7
		for(int i=posX-4,j=posY;i<posX;i++){
		  if(i>=0&&i<chessboard.BOARD_SIZE&&j>=0&&j<chessboard.BOARD_SIZE){
			if(!board[i][j].equals(ico)){
				b[6]=false;
				break;
			}
		  }
		}
		//8
		for(int i=posX-4,j=posY-4;i<posX&&j<posY;i++,j++){
		  if(i>=0&&i<chessboard.BOARD_SIZE&&j>=0&&j<chessboard.BOARD_SIZE){
			if(!board[i][j].equals(ico)){
				b[7]=false;
				break;
			}
		  }
		}
		for(int i=0;i<b.length;i++){
			if(b[i]==true){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
