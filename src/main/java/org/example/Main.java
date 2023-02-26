package org.example;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        FileManager fileManager = new FileManager("C:\\JP\\FileManager\\root"); // Absolutes Path

        System.out.println("Привет, я файловый менеджер! Если что-то непонятно -> help");
        String input = scanner.nextLine();

        while (!input.equals(Commands.EXIT)) {
            // cd file.txt x.txt -> tokens[0] = cd, tokens[1] = file.txt, tokens[2] = x.txt
            String tokens[] = input.split(" "); // cd Desktop tokens[0} = cd, tokens[1] = Desktop
            String command = tokens[0];
            switch (command) {
                case Commands.LIST_OF_FILE:
                    fileManager.listOfFile(false);
                    break;
                case Commands.LIST_OF_FILE_WITH_SIZE:
                    fileManager.listOfFile(true);
                    break;
                case Commands.COPY_FILE: {
                    String sourceFileName = tokens[1];
                    String deskFileName = tokens[2];
                    fileManager.copyFile(sourceFileName, deskFileName);
                    break;
                }
                case Commands.CREATE_FILE: {
                    String fileName = tokens[1];
                    fileManager.createFile(fileName);
                    break;
                }
                case Commands.FILE_CONTENT: {
                    String fileName = tokens[1];
                    fileManager.fileContent(fileName);
                    break;
                }
                case Commands.CHANGE_DIRECTORY: {
                    String folderName = tokens[1];
                    fileManager.changeDirectory(folderName);
                    break;
                }
                case Commands.HELP:
                    fileManager.help();
                    break;
                case Commands.DELETE: {
                    String deleteFile = tokens[1];
                    fileManager.delete(deleteFile);
                    break;
                }
                case Commands.RENAME: {
                    String actualFile = tokens[1];
                    String renameFile = tokens[2];
                    fileManager.rename(actualFile, renameFile);
                    break;
                }
                case Commands.SHOW_FILE: {
                    String showFile = tokens[1];
                    fileManager.showFileInfo(showFile);
                    break;
                }
                case Commands.SHOW_PATH_FILE: {
                    String showFilePath = tokens[1];
                    fileManager.showPath(showFilePath);
                    break;
                }
                case Commands.CREATE_DIRECTORY: {
                    String createDirectory = tokens[1];
                    fileManager.createDirectoryIn(createDirectory);
                    break;
                }
                case Commands.MOVE_FILE:
                    String moveFile = tokens[1];
                    String moveInDirectory = tokens[2];
                    fileManager.move(moveFile, moveInDirectory);
                    break;
                default:
                    System.out.println("Неверная команда:");
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
