package view;

import presenter.TreePresenter;
import model.Person;
import java.util.List;

public interface FamilyTree extends MessageView, PersonView, InputView{
    void setPresenter(TreePresenter presenter);
}
