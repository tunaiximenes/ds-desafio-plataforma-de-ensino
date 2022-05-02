package applications;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    //
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);
      List<Lesson> list = new ArrayList<>();

      System.out.print("Quantas aulas tem o curso? ");
      int n = sc.nextInt();
      for(int i=1; i<=n; i++){
          System.out.println();
          System.out.println("Dados da "+ i +"a aula:");
          System.out.print("Conteúdo ou tarefa (c/t)? ");
          char cont = sc.next().charAt(0);
          System.out.print("Título: ");
          sc.nextLine();
          String title = sc.nextLine();
          switch (cont){
              case 'c' -> {
                 System.out.print("URL do vídeo: ");
                 String url = sc.nextLine();
                 System.out.print("Duração em segundos: ");
                 int duration = sc.nextInt();
                 list.add(new Video(title,url,duration));
              }
              case 't' -> {
                  System.out.print("Descrição: ");
                  String description = sc.nextLine();
                  System.out.print("Quantidade de questões: ");
                  int questionCount = sc.nextInt();
                  list.add(new Task(title, description,questionCount));
              }
          }
      }

      int sum = 0;
      for (Lesson lt: list) {
          sum += lt.duration();
      }
      System.out.println();
      System.out.println("DURAÇÃO TOTAL DO CURSO = " + sum + " segundos");
      sc.close();
  }
}
