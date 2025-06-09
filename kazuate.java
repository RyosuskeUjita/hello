import java.util.Scanner; // Scannerクラスをインポート

public class kazuate {
    public static void main(String[] args) {
        // プログラマーが設定する数（2桁の正の整数）
        final int TARGET_NUMBER = 42; // ここに任意の2桁の正の整数を設定します

        Scanner scanner = new Scanner(System.in); // Scannerオブジェクトを作成
        int guess = 0; // ユーザーの入力値を格納する変数。初期化を追加
        int attempts = 0; // 試行回数をカウントする変数
        final int MAX_ATTEMPTS = 5; // 最大試行回数

        System.out.println("2桁の正の整数を当ててください。試行回数は" + MAX_ATTEMPTS + "回までです。");

        // 試行回数内でのループ
        while (attempts < MAX_ATTEMPTS) {
            System.out.print((attempts + 1) + "回目の入力: ");
            
            // 入力が整数であるかを確認
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt(); // ユーザーの入力を読み込む

                // 2桁の正の整数であるかを確認
                if (guess < 10 || guess > 99) {
                    System.out.println("不正な入力です。2桁の正の整数を入力してください。");
                    //scanner.next(); // 不正な入力の場合、ここでスキップすると、次の入力で問題が起こる可能性があるので削除
                    continue; // ループの最初に戻る
                }

                attempts++; // 試行回数を増やす

                if (guess == TARGET_NUMBER) {
                    System.out.println("当たり！おめでとうございます！");
                    break; // ゲーム終了
                } else {
                    // 設定された数との差を計算
                    int difference = Math.abs(TARGET_NUMBER - guess);

                    if (difference >= 20) {
                        System.out.println("設定された数との差が20以上あります。");
                    }

                    if (guess < TARGET_NUMBER) {
                        System.out.println("設定された数より小さいです。");
                    } else {
                        System.out.println("設定された数より大きいです。");
                    }
                }
            } else {
                System.out.println("不正な入力です。整数を入力してください。");
                scanner.next(); // 不正な入力をスキップ
            }
        }

        // 試行回数が上限に達した場合 (最終的なguessの値がTARGET_NUMBERと一致しない場合)
        if (attempts == MAX_ATTEMPTS && guess != TARGET_NUMBER) {
            System.out.println("残念、" + MAX_ATTEMPTS + "回の試行を使い切りました。正解は" + TARGET_NUMBER + "でした。");
        }

        scanner.close(); // Scannerオブジェクトを閉じる
    }
}