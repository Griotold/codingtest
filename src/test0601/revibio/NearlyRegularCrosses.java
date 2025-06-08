package test0601.revibio;
/**
 * 3번 문제
 * 거의 같은 교차
 * */
public class NearlyRegularCrosses {

    private boolean isNearlyRegularCross(int[][] matrix, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 행 체크 (교차점 제외)
        boolean rowRegular = isRowRegular(matrix, row, col);

        // 열 체크 (교차점 제외)
        boolean colRegular = isColRegular(matrix, row, col);

        return rowRegular && colRegular;
    }

    private boolean isRowRegular(int[][] matrix, int row, int excludeCol) {
        if (matrix[row].length <= 1) return true; // 교차점만 있으면 true

        // 교차점이 아닌 첫 번째 값을 기준으로 설정
        int baseValue = -1;
        for (int j = 0; j < matrix[row].length; j++) {
            if (j != excludeCol) {
                baseValue = matrix[row][j];
                break;
            }
        }

        // 나머지 값들이 기준값과 같은지 확인
        for (int j = 0; j < matrix[row].length; j++) {
            if (j != excludeCol && matrix[row][j] != baseValue) {
                return false;
            }
        }

        return true;
    }

    private boolean isColRegular(int[][] matrix, int excludeRow, int col) {
        if (matrix.length <= 1) return true; // 교차점만 있으면 true

        // 교차점이 아닌 첫 번째 값을 기준으로 설정
        int baseValue = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (i != excludeRow) {
                baseValue = matrix[i][col];
                break;
            }
        }

        // 나머지 값들이 기준값과 같은지 확인
        for (int i = 0; i < matrix.length; i++) {
            if (i != excludeRow && matrix[i][col] != baseValue) {
                return false;
            }
        }

        return true;
    }

    public int solution(int[][] matrix) {
        int count = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 모든 위치에서 cross 체크
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isNearlyRegularCross(matrix, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NearlyRegularCrosses nrc = new NearlyRegularCrosses();

        // 테스트 케이스
        int[][] matrix = {
                {1, 1, 1, 1},
                {2, 1, 1, 1},
                {1, 1, 1, 0},
                {3, 3, 1, 1}
        };

        int result = nrc.solution(matrix);

        System.out.println("입력 행렬:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j < matrix[i].length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        System.out.println("\n결과: " + result);

        // 상세 분석
        System.out.println("\n상세 분석:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean isRegular = nrc.isNearlyRegularCross(matrix, i, j);
                System.out.printf("위치 (%d,%d): %s", i, j, isRegular ? "O" : "X");

                if (isRegular) {
                    System.out.print(" - 행: [");
                    for (int k = 0; k < matrix[i].length; k++) {
                        if (k != j) {
                            System.out.print(matrix[i][k]);
                            if (k < matrix[i].length - 1 && k + 1 != j) System.out.print(",");
                        }
                    }
                    System.out.print("] 열: [");
                    for (int k = 0; k < matrix.length; k++) {
                        if (k != i) {
                            System.out.print(matrix[k][j]);
                            if (k < matrix.length - 1 && k + 1 != i) System.out.print(",");
                        }
                    }
                    System.out.print("]");
                }
                System.out.println();
            }
        }
    }
}
