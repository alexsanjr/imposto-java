import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Renda anual com salário: ");
        double salario = sc.nextDouble();

        System.out.print("Renda anual com prestação de serviço: ");
        double prestacaoServico = sc.nextDouble();

        System.out.print("Renda anual com ganho de capital: ");
        double ganhoCapital = sc.nextDouble();

        System.out.print("Gastos médicos: ");
        double gastosMedicos = sc.nextDouble();

        System.out.print("Gastos educacionais: ");
        double gastosEducacionais = sc.nextDouble();
        sc.close();

        // Calculo imposto

        double impostoSalario = 0.0;
        if (salario / 12 > 3000 && salario / 12 < 5000) {
            impostoSalario = salario * 0.1;
        } else if (salario / 12 >= 5000) {
            impostoSalario = salario * 0.2;
        }

        double impostoServico = 0.0;
        if (prestacaoServico > 0) {
            impostoServico = prestacaoServico * 0.15;
        }

        double impostoGanhoCapital = 0.0;
        if (ganhoCapital > 0) {
            impostoGanhoCapital = ganhoCapital * 0.2;
        }

        double impostoTotal = impostoServico + impostoSalario + impostoGanhoCapital;
        double maxDedutivel = impostoTotal * 0.3;

        // Calculo Dedutível
        double gastosDedutiveis = gastosMedicos + gastosEducacionais;
        double dedutivel = 0.0;
        if (gastosDedutiveis > 0) {
            if (gastosDedutiveis < maxDedutivel) {
                dedutivel = gastosDedutiveis;
            } else {
                dedutivel = maxDedutivel;
            }
        }

        System.out.println("\nRELATÓRIO DE IMPOSTO DE RENDA\n");

        System.out.println("CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f\n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f\n", impostoServico);
        System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoGanhoCapital);

        System.out.println("\nDEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f\n", maxDedutivel);
        System.out.printf("Gastos dedutíveis: %.2f\n", gastosDedutiveis);

        System.out.println("\nRESUMO:");
        System.out.printf("Imposto bruto total: %.2f\n", impostoTotal);
        System.out.printf("Abatimento: %.2f\n", dedutivel);
        System.out.printf("Imposto devido: %.2f\n", impostoTotal - dedutivel);
    }
}
