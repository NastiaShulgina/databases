package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.controller.impl.*;
import ua.lviv.iot.model.*;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class View {

    private static final String KEY_EXIT = "Q";
    private static final String TEXT_GO_BACK = "Go back or quit";
    private static final String TEXT_SELECT_MENU_OPTION = "Please choose menu option: ";
    private static final String ERROR_NO_SUCH_OPTION = "No such option found. Try again.";

    private static final Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

    public void show() {
        showTablesMenu();
    }

    /**
     * Show general tables MENU
     */
    private void showTablesMenu() {
        Map<String, String> tablesMenu = generateTablesMenu();
        Map<String, Printable> tablesMenuMethods = generateTablesMenuMethods();
        showMenuFromMaps(tablesMenu, tablesMenuMethods);
    }

    /**
     * Generate general tables MENU and MENU METHODS
     */

    private Map<String, String> generateTablesMenu() {
        Map<String, String> tablesMenu = new LinkedHashMap<>();
        tablesMenu.put("1", "Table: Problem");
        tablesMenu.put("2", "Table: Responsible worker");
        tablesMenu.put("3", "Table: Solution");
        tablesMenu.put("4", "Table: Location");
        tablesMenu.put("5", "Table: Application");
        return tablesMenu;
    }
    private Map<String, Printable> generateTablesMenuMethods() {
        Map<String, Printable> tablesMenuMethods = new LinkedHashMap<>();
        tablesMenuMethods.put("1", this::showProblemMenu);
        tablesMenuMethods.put("2", this::showResponsibleWorkerMenu);
        tablesMenuMethods.put("3", this::showSolutionMenu);
        tablesMenuMethods.put("4", this::showLocationMenu);
        tablesMenuMethods.put("5", this::showApplicationMenu);
        return tablesMenuMethods;
    }

    /**
     * Show single table MENU
     */
    private void showProblemMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateProblemMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showResponsibleWorkerMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateResponsibleWorkerMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showSolutionMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateSolutionMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showLocationMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateLocationMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showApplicationMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateApplicationMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }



    /**
     * Generate single table MENU
     */
    private Map<String, String> generateMenu() {
        Map<String, String> menu = new LinkedHashMap<>();
        menu.put("1", "Select all");
        menu.put("2", "Select");
        menu.put("3", "Create");
        menu.put("4", "Update");
        menu.put("5", "Delete");
        return menu;
    }

    /**
     * Generate single table MENU METHODS
     */
    private Map<String, Printable> generateProblemMenuMethods() {
        AbstractController<Problem, Integer> problemController = new ProblemControllerImpl();
        ViewOperations<Problem, Integer> problemOperation = new ViewOperations<>(problemController, Problem.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", problemOperation::findAll);
        menuMethods.put("2", problemOperation::findById);
        menuMethods.put("3", problemOperation::create);
        menuMethods.put("4", problemOperation::update);
        menuMethods.put("5", problemOperation::delete);
        return menuMethods;
    }



    private Map<String, Printable> generateResponsibleWorkerMenuMethods() {
        AbstractController<ResponsibleWorker, Integer> responsibleWorkerController = new ResponsibleWorkerControllerImpl();
        ViewOperations<ResponsibleWorker, Integer> responsibleWorkerOperation = new ViewOperations<>(responsibleWorkerController, ResponsibleWorker.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", responsibleWorkerOperation::findAll);
        menuMethods.put("2", responsibleWorkerOperation::findById);
        menuMethods.put("3", responsibleWorkerOperation::create);
        menuMethods.put("4", responsibleWorkerOperation::update);
        menuMethods.put("5", responsibleWorkerOperation::delete);
        return menuMethods;
    }



    private Map<String, Printable> generateSolutionMenuMethods() {
        AbstractController<Solution, String> solutionController = new SolutionControllerImpl();
        ViewOperations<Solution, String> solutionOperation = new ViewOperations<>(solutionController, Solution.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", solutionOperation::findAll);
        menuMethods.put("2", solutionOperation::findById);
        menuMethods.put("3", solutionOperation::create);
        menuMethods.put("4", solutionOperation::update);
        menuMethods.put("5", solutionOperation::delete);
        return menuMethods;
    }


    private Map<String, Printable> generateLocationMenuMethods() {
        AbstractController<Location, Integer> locationController = new LocationControllerImpl();
        ViewOperations<Location, Integer> locationOperation = new ViewOperations<>(locationController, Location.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", locationOperation::findAll);
        menuMethods.put("2", locationOperation::findById);
        menuMethods.put("3", locationOperation::create);
        menuMethods.put("4", locationOperation::update);
        menuMethods.put("5", locationOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateApplicationMenuMethods() {
        AbstractController<Application, Integer> applicationController = new ApplicationControllerImpl();
        ViewOperations<Application, Integer> applicationOperation = new ViewOperations<>(applicationController, Application.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", applicationOperation::findAll);
        menuMethods.put("2", applicationOperation::findById);
        menuMethods.put("3", applicationOperation::create);
        menuMethods.put("4", applicationOperation::update);
        menuMethods.put("5", applicationOperation::delete);
        return menuMethods;
    }

    /**
     * Show menu from Maps
     */
    private void showMenuFromMaps(Map<String, String> keyName, Map<String, Printable> keyMethod) {
        String keyMenu;
        do {
            printMenu(keyName);
            System.out.println(TEXT_SELECT_MENU_OPTION);
            keyMenu = input.nextLine().toUpperCase();
            Printable method = keyMethod.get(keyMenu);
            if (method != null) {
                method.print();
            } else if (!keyMenu.equals(KEY_EXIT)) {
                System.out.println(ERROR_NO_SUCH_OPTION);
            }
        } while (!keyMenu.equals(KEY_EXIT));
    }

    private void printMenu(Map<String, String> keyName) {
        keyName.forEach((key, value) -> System.out.printf("%3s - %s%n", key, value));
        System.out.printf("%3s - %s%n", KEY_EXIT, TEXT_GO_BACK);
    }
}
