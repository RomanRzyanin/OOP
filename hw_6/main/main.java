package main;

import model.F_Tree;
import model.Person;
import presenter.CommandHandler;
import presenter.TreePresenter;
import service.FileOperationsImpl;
import view.ConsoleTreeView;

public class Main {
public static void main(String[] args) {
    F_Tree<Person> familyTree = new F_Tree<>();
    ConsoleTreeView view = new ConsoleTreeView();
    FileOperationsImpl<Person> fileOperations = new
    FileOperationsImpl<>();
    TreePresenter presenter = new TreePresenter(familyTree, view, view, view, fileOperations);
    CommandHandler commandHandler = new CommandHandler(presenter, view);
    commandHandler.handleUserInput();
    }
}