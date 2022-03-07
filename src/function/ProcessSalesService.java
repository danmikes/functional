package function;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ProcessSalesService {
  private static IO<List<String>> readFile(String file) {
    return () -> {
      try (Stream<String> stream = Files.lines(Paths.get(file))) {

        return stream
          .filter(line -> line.startsWith("SD"))
          .toList();
      } catch (IOException e){
        throw new RuntimeException(e);
      }
    };
  }

  private static List<String> log (List<String> sales) {
    System.out.println("sales = " + sales.size());

    return sales;
  }

  private static IO<Unit> writeFile(List<String> discountedSales, String file) {
    return () -> {
      try {
        Files.write(
          Paths.get(file),
          discountedSales, Charset.defaultCharset()
        );
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      return Unit.instance;
    };
  }

  private static IO<Unit> processSale(String inputFile, String outputFile) {
    IO<Unit> program = readFile(inputFile)
      .map(sales -> log(sales))
      .flatMap(sales -> writeFile(sales, outputFile));

    return program;
  }

  public static void main(String[] args) {
    processSale(
      "//temp/sales.txt",
      "//temp/discountedSales.txt"
    ).run();
  }
}
