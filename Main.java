import controller.FuncionarioController;
import model.FuncionarioDAO;
import view.FuncionarioView;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            FuncionarioView view = new FuncionarioView();
            FuncionarioDAO dao = new FuncionarioDAO();
            new FuncionarioController(view, dao);
        });
    }
}
