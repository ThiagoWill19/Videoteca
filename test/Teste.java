
import com.thiagowill.videoteca.dal.FilmeDAL;
import com.thiagowill.videoteca.models.Filme;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Filme f = new Filme();
        FilmeDAL fd = new FilmeDAL();
        List <Filme> list =  new ArrayList<>();
        
        f.setTitulo("Duro de matar");
        f.setDuracao(90);
        
        fd.insert(f);
        
        list = fd.findAll();
        System.out.println(list);

    }

}
