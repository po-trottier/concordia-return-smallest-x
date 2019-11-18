import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    int[] array = { 4, 6, 8, 9, 2, 92, 29, 16, 11, 7, 3, 22, 1 };
    int x = 6;

    int[] answer = returnFirstX(array, x);

    System.out.println(Arrays.toString(answer));
  }

  private static int[] returnFirstX(int[] array, int x) {
    int[] sorted = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      if (i == 0) {
        sorted[0] = array[i];
        continue;
      }

      boolean inserted = false;

      for (int j = 0; j < i; j++) {
        if (sorted[j] > array[i]) {
          for (int k = i - 1; k >= j; k--) {
            sorted[k + 1] = sorted[k];
          }
          sorted[j] = array[i];
          inserted = true;
          break;
        }
      }

      if (!inserted)
        sorted[i] = array[i];
    }

    int[] returnValue = new int[x];
    for (int i = 0; i < x; i++) {
      returnValue[i] = sorted[i];
    }

    return returnValue;
  }
}
