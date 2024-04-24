import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int instancias = input.nextInt();

        for (int i = 0; i < instancias; i++){
            int bonus = input.nextInt();
            int ataque1 = input.nextInt();
            int defesa1 = input.nextInt();
            int level1 = input.nextInt();
            int ataque2 = input.nextInt();
            int defesa2 = input.nextInt();
            int level2 = input.nextInt();

            Treinador dabriel = new Treinador("Dabriel",level1);
            Treinador guarte = new Treinador("Guarte", level2);

            Pomekon pomekonDabriel = new Pomekon(ataque1,defesa1,dabriel);
            Pomekon pomekonGuarte = new Pomekon(ataque2,defesa2,guarte);

            Batalha batalha = new Batalha(bonus,pomekonDabriel,pomekonGuarte);

            String vencedor = batalha.vencedor();
            System.out.println(vencedor);
        }

    }
}

 class Treinador {
    private String nome;
    private int level;

    public Treinador(String nome, int level){
        this.nome = nome;
        this.level = level;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }

}

 class Pomekon {
    private int ataque;
    private int defesa;
    private Treinador treinador;

    public Pomekon (int ataque, int defesa, Treinador treinador){
        this.ataque = ataque;
        this.defesa = defesa;
        this.treinador = treinador;
    }

    public int getAtaque(){
        return ataque;
    }
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    public int getDefesa(){
        return defesa;
    }
    public void setDefesa(int defesa){
        this.defesa = defesa;
    }
    public Treinador getTreinador(){
        return treinador;
    }
    public void setTreinador(){
        this.treinador = treinador;
    }

    public int valorGolpe(int bonus){
        if (treinador.getLevel() % 2 == 0){
            return (ataque + defesa)/2 + bonus;
        } else {
            return (ataque + defesa)/2;
        }
    }

}

 class Batalha {
    int bonus;
    Pomekon pomekon1;
    Pomekon pomekon2;

    public Batalha (int bonus, Pomekon pomekon1, Pomekon pomekon2){
        this.bonus = bonus;
        this.pomekon1 = pomekon1;
        this.pomekon2 = pomekon2;
    }

    public int getBonus(){
        return bonus;
    }
    public void setBonus(int bonus){
        this.bonus = bonus;
    }
    public Pomekon getPomekon1(){
        return pomekon1;
    }
    public void setPomekon1(Pomekon pomekon1){
        this.pomekon1 = pomekon1;
    }
    public Pomekon getPomekon2(){
        return pomekon2;
    }
    public void setPomekon2(Pomekon pomekon2){
        this.pomekon2 = pomekon2;
    }

    public String vencedor(){
        int vg1 = pomekon1.valorGolpe(bonus);
        int vg2 = pomekon2.valorGolpe(bonus);
        if (vg1 > vg2){
           return "Dabriel";
        } else if (vg2 > vg1) {
            return "Guarte";
        } else{
            return "Empate";
        }
    }
}
