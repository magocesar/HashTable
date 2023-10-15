import Hash.LinearProbingHash;
import Hash.QuadraticProbingHash;
import Hash.DllHash;
import aux_proj.Aluno;

public class Programn {
    public static void main(String[] args) {
        
        Aluno cesar = new Aluno(0, "Cesar");
        Aluno joao = new Aluno(10, "Joao");
        Aluno maria = new Aluno(11, "Maria");
        Aluno pedro = new Aluno(127, "Pedro");
        Aluno rodrigo = new Aluno(984, "Rodrigo");
        Aluno ana = new Aluno(521, "Ana");
        Aluno carla = new Aluno(735, "Carla");
        Aluno david = new Aluno(452, "David");
        Aluno evelyn = new Aluno(876, "Evelyn");
        Aluno fernando = new Aluno(311, "Fernando");
        Aluno gabriela = new Aluno(690, "Gabriela");
        Aluno hugo = new Aluno(822, "Hugo");
        Aluno isabela = new Aluno(573, "Isabela");
        Aluno julio = new Aluno(145, "Julio");
        Aluno karen = new Aluno(871, "Karen");
        Aluno lucas = new Aluno(404, "Lucas");
        Aluno marina = new Aluno(239, "Marina");
        Aluno nathan = new Aluno(782, "Nathan");
        Aluno olivia = new Aluno(356, "Olivia");
        Aluno paulo = new Aluno(171, "Paulo");
        Aluno alice = new Aluno(936, "Alice");
        Aluno bruno = new Aluno(821, "Bruno");
        Aluno clara = new Aluno(666, "Clara");
        Aluno daniel = new Aluno(997, "Daniel");
        Aluno elisa = new Aluno(458, "Elisa");
        Aluno felipe = new Aluno(623, "Felipe");
        Aluno gisele = new Aluno(333, "Gisele");
        Aluno henrique = new Aluno(543, "Henrique");
        Aluno isabel = new Aluno(298, "Isabel");
        Aluno jorge = new Aluno(109, "Jorge");
        Aluno karla = new Aluno(853, "Karla");
        Aluno leandro = new Aluno(715, "Leandro");
        Aluno marcela = new Aluno(618, "Marcela");
        Aluno nelson = new Aluno(527, "Nelson");
        Aluno olga = new Aluno(789, "Olga");
        Aluno pedrao = new Aluno(600, "Pedrao");
        Aluno quiteria = new Aluno(345, "Quiteria");
        Aluno roberto = new Aluno(479, "Roberto");
        Aluno silvia = new Aluno(234, "Silvia");
        Aluno tiago = new Aluno(999, "Tiago");

        //DllHash hash = new DllHash(9, 0.75);
        LinearProbingHash hash = new LinearProbingHash(9, 0.75);
        //QuadraticProbingHash hash = new QuadraticProbingHash(9, 0.75);

        hash.inserir(cesar);
        hash.inserir(joao);
        hash.inserir(maria);
        hash.inserir(pedro);
        hash.inserir(rodrigo);
        hash.inserir(ana);
        hash.inserir(carla);
        hash.inserir(david);
        hash.inserir(evelyn);
        hash.inserir(fernando);
        hash.inserir(gabriela);
        hash.inserir(hugo);
        hash.inserir(isabela);
        hash.inserir(julio);
        hash.inserir(karen);
        hash.inserir(lucas);
        hash.inserir(marina);
        hash.inserir(nathan);
        hash.inserir(olivia);
        hash.inserir(paulo);
        hash.inserir(alice);
        hash.inserir(bruno);
        hash.inserir(clara);
        hash.inserir(daniel);
        hash.inserir(elisa);
        hash.inserir(felipe);
        hash.inserir(gisele);
        hash.inserir(henrique);
        hash.inserir(isabel);
        hash.inserir(jorge);
        hash.inserir(karla);
        hash.inserir(leandro);
        hash.inserir(marcela);
        hash.inserir(nelson);
        hash.inserir(olga);
        hash.inserir(pedrao);
        hash.inserir(quiteria);
        hash.inserir(roberto);
        hash.inserir(silvia);
        hash.inserir(tiago);

        System.out.println(hash.remover(9).getNome());
    }
}