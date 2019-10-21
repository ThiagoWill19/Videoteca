

import com.thiagowill.videoteca.models.Jogo;
import com.thiagowill.videoteca.services.JogoService;
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

        JogoService js =  new JogoService();
        List<Jogo> list = new ArrayList<>();
        Jogo j =  new Jogo(5, "Driver 2", "PS1",2);
    
        
        
        System.out.println(js.instantSearch("res"));
        
    }

}
