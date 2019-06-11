import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Pokemon
{
    public static String name = "";
    public static String trainerPokemon = ""; 
    public static String pathChosen = "";
    public static boolean win = false;
    
    public static void main(String[] args)
    {
        Pikachu pik = new Pikachu();
        Squirtle squ = new Squirtle();
        Charmander cha = new Charmander();
        Bulbasaur bul = new Bulbasaur();
        Rattata rat = new Rattata();
        
        double trainerAttack = 0;
        double trainerDefense = 0;
        double trainerHp = 0;
        String trainerMove1 = "";
        String trainerMove2 = "";
        String trainerType = "";
        Banner();
        Scanner scan = new Scanner(System.in);
        typeWriter("What is your name?\n");
        name = scan.nextLine();
        
        typeWriter("You come across three baby pokemon...\n");
        sleep(2000);
        typeWriter("A mysterious man appears and says you must choose one...\n");
        sleep(2000);
        typeWriter("which pokemon do you choose: \n");
        sleep(1000);
        
        Scanner Scan = new Scanner(System.in);
        typeWriter("Bulbasaur\nSquirtle\nCharmander\n");
        trainerPokemon = Scan.nextLine();
        
        
        
        if(trainerPokemon.equals("Bulbasaur")){
            trainerPokemon = "Bulbasaur";
            trainerAttack = bul.attack;
            trainerDefense = bul.defense;
            trainerHp = bul.hp;
            trainerMove1 = bul.moveSet[0];
            trainerMove2 = bul.moveSet[1];
            trainerType = bul.type;
            
            drawBulbasaur();
        }else if(trainerPokemon.equals("Squirtle")){
            
            trainerPokemon = "Squirtle";
            
            trainerAttack = squ.attack;
            trainerDefense = squ.defense;
            trainerHp = squ.hp;
            trainerMove1 = squ.moveSet[0];
            trainerMove2 = squ.moveSet[1];
            trainerType = squ.type;
            
            drawSquirtle();
        }else if(trainerPokemon.equals("Charmander")){
            trainerPokemon = "Charmander";
            
            trainerAttack = cha.attack;
            trainerDefense = cha.defense;
            trainerHp = cha.hp;
            trainerMove1 = cha.moveSet[0];
            trainerMove2 = cha.moveSet[1];
            trainerType = cha.type;
            
            drawCharmander();
        }
        sleep(1000);
        typeWriter(trainerPokemon + " was added to your backpack...\n");
        sleep(1000);
        
        move();
        firstBattle(pathChosen);
        String wildPokemon = bul.name;
        double wildAttack = bul.attack;
        double wildDefense = bul.defense;
        double wildHp = bul.hp;
        String wildMove1 = bul.moveSet[0];
        String wildMove2 = bul.moveSet[1];
        String wildType = bul.type;

       battle(trainerPokemon, trainerAttack, trainerDefense, trainerHp, trainerMove1, trainerMove2, trainerType, wildPokemon, wildAttack, wildDefense, wildHp, wildMove1, wildMove2, wildType, name);
        
    }
    
    public static void Banner()
    {
        type(" __      __                _________               .__    __________       __                                 \n");
        type("/  \\    /  \\_____  ___.__. \\_   ___ \\  ____   ____ |  |   \\______   \\____ |  | __ ____   _____   ____   ____  \n");
        type("\\   \\/\\/   /\\__  \\<   |  | /    \\  \\/ /  _ \\ /  _ \\|  |    |     ___/  _ \\|  |/ // __ \\ /     \\ /  _ \\ /    \\ \n");
        type(" \\        /  / __ \\\\___  | \\     \\___(  <_> |  <_> )  |__  |    |  (  <_> )    <\\  ___/|  Y Y  (  <_> )   |  \\\n");
        type("  \\__/\\  /  (____  / ____|  \\______  /\\____/ \\____/|____/  |____|   \\____/|__|_ \\\\___  >__|_|  /\\____/|___|  /\n");
        type("       \\/        \\/\\/              \\/                                          \\/    \\/      \\/            \\/ \n");
        sleep(1000);
    }
    
    public static void Win()
    {
        type("_____.___.              .__                        __      __            ._.\n");
        type("\\__  |   | ____  __ __  |  |__ _____ ___  __ ____ /  \\    /  \\____   ____| |\n");
        type(" /   |   |/  _ \\|  |  \\ |  |  \\__  \\  \\/ // __ \\  \\   \\/\\/   /  _ \\ /    \\ |\n");
        type(" \\____   (  <_> )  |  / |   Y  \\/ __\\   /\\  ___/   \\        (  <_> )   |  \\|\n");
        type(" / ______|\\____/|____/  |___|  (____ /\\_/ \\___  >   \\__/\\  / \\____/|___|  /_\n");
        type(" \\/                          \\/     \\/        \\/         \\/             \\/\\/\n");
    }
    
    public static void Lose(){
        type("_____.___.              .__                         .____                   __  ._.\n");
        type("\\__  |   | ____  __ __  |  |__ _____ ___  __ ____   |    |    ____  _______/  |_| |\n");
        type(" /   |   |/  _ \\|  |  \\ |  |  \\\\__  \\\\  \\/ // __ \\  |    |   /  _ \\/  ___/\\   __\\ |\n");
        type(" \\____   (  <_> )  |  / |   Y  \\/ __ \\\\   /\\  ___/  |    |__(  <_> )___ \\  |  |  \\|\n");
        type(" / ______|\\____/|____/  |___|  (____  /\\_/  \\___  > |_______ \\____/____  > |__|  __\n");
        type(" \\/                          \\/     \\/          \\/          \\/         \\/        \\/\n");
    }
    
    public static void move(){
            typeWriter("You come upon a path that goes east and west...\n");
            Scanner scan = new Scanner(System.in);
            sleep(1000);
            typeWriter("Which path do you take:\n1: East\n2: West\n");
            pathChosen = scan.nextLine();
            if(pathChosen.equals("East")){
                pathChosen = "East";
                typeWriter("You're headed East...\n");
            }else if(pathChosen.equals("West")){
                pathChosen = "West";
                typeWriter("You're headed West...\n");
            }
    }
    
    public static void firstBattle(String path){
        sleep(1000);
        typeWriter("Youre walking when...\n");
        sleep(2000);
        if(path.equals("East")){
            drawPikachu();
            typeWriter("A wild Pikachu appears!\n");
            
        }else if(path.equals("West")){
            drawRattata();
            typeWriter("A wild Rattata appears!\n");
            
        }
    }
    
    public static void battle(String trainerPokemon, double trainerAttack, double trainerDefense, double trainerHp, String trainerMove1, String trainerMove2, String trainerType, String wildPokemon, double wildAttack, double wildDefense, double wildHp, String wildMove1, String wildMove2, String wildType, String name)
    {
        while(trainerHp > 0 && wildHp > 0)
        {
            // User input for battle decision
            Scanner sc = new Scanner(System.in);
            System.out.println("Attack or Run?");
            String decision = sc.nextLine();
            
            
            
            
            // Random number for wild pokemon attack
            Random rand = new Random();
            int  random = rand.nextInt(2) + 1;
            
            
            
            // Battle Decision
            if(decision.equals("Attack"))
            {
                sc = new Scanner(System.in);
                System.out.println(trainerMove1 + " or " + trainerMove2 + "?");
                String choice = sc.nextLine();
                System.out.println(name + "'s " + trainerPokemon + " used " + choice +".");
                wildHp = trainerAttack(choice, trainerAttack, wildDefense, wildType, wildHp);
                if(wildHp <= 0)
                {
                    System.out.println(wildPokemon + " has fainted.\n" );
                    Win();
                    break;
                }
                else
                {
                    System.out.println(wildPokemon + " has " + roundAvoid(wildHp, 2) + " HP.");
                }
                
                if(random == 1)
                {
                    System.out.println(wildPokemon + " used " + wildMove1 + ".");
                }
                
                else
                {
                    System.out.println(wildPokemon + " used " + wildMove2 + ".");
                }
                
                trainerHp = wildAttack(random, wildMove2, wildAttack, trainerDefense, trainerType, trainerHp);
                if(trainerHp <= 0)
                {
                    System.out.println(name + "'s " + trainerPokemon + " has fainted.\n" );
                    Lose();
                    break;
                }
                else
                {
                    System.out.println(name +"'s " + trainerPokemon + " has " + roundAvoid(trainerHp, 2) + " HP.\n");
                }
            }
            
            else
            {
                System.out.println("You could not run away.");
                
                if(random == 1)
                {
                    System.out.println(wildPokemon + " used " + wildMove1 + ".");
                }
                
                else
                {
                    System.out.println(wildPokemon + " used " + wildMove2 + ".");
                }
                
                trainerHp = wildAttack(random, wildMove2, wildAttack, trainerDefense, trainerType, trainerHp);
                if(trainerHp <= 0)
                {
                    System.out.println(name + "'s " + trainerPokemon + " has fainted.\n" );
                    Lose();
                    break;
                }
                else
                {
                    System.out.println(name +"'s " + trainerPokemon + " has " + roundAvoid(trainerHp, 2) + " HP.\n");
                    Win();
                }
            }
        }
    }
    
    public static double wildAttack(int random, String wildMove2, double wildAttack, double trainerDefense, String trainerType, double trainerHp)
    {
        double damage;
        if(random == 1)
        {
            damage = wildAttack * 0.4 - (trainerDefense / 5);
            trainerHp = trainerHp - damage;
        }
        else
        {
            if(wildMove2.equals("Spark"))
            {
                damage = wildAttack * 0.5 - (trainerDefense / 5);
                if(trainerType.equals("Water"))
                {
                    damage = damage * 2;
                }
                else if(trainerType.equals("Grass"))
                {
                    damage = damage / 2;
                }
                trainerHp = trainerHp - damage;
            }
            else if(wildMove2.equals("Mud Slap"))
            {
                damage = wildAttack * 0.4 - (trainerDefense / 5);
                if(trainerType.equals("Fire"))
                {
                    damage = damage * 2;
                }
                else if(trainerType.equals("Electric"))
                {
                    damage = damage * 2;
                }
                else if(trainerType.equals("Grass"))
                {
                    damage = damage / 2;
                }
                trainerHp = trainerHp - damage;
            }
            else if(wildMove2.equals("Ember"))
            {
                damage = wildAttack * 0.5 - (trainerDefense / 5);
                if(trainerType.equals("Grass"))
                {
                    damage = damage * 2;
                }
                else if(trainerType.equals("Water"))
                {
                    damage = damage / 2;
                }
                trainerHp = trainerHp - damage;
            }
            else if(wildMove2.equals("Water Gun"))
            {
                damage = wildAttack * 0.5 - (trainerDefense / 5);
                if(trainerType.equals("Fire"))
                {
                    damage = damage * 2;
                }
                else if(trainerType.equals("Grass"))
                {
                    damage = damage / 2;
                }
                trainerHp = trainerHp - damage;
            }
            else if(wildMove2.equals("Razor Leaf"))
            {
                damage = wildAttack * 0.5 - (trainerDefense / 5);
                if(trainerType.equals("Water"))
                {
                    damage = damage * 2;
                }
                else if(trainerType.equals("Fire"))
                {
                    damage = damage / 2;
                }
                trainerHp = trainerHp - damage;
            }
        }
        return trainerHp;
    }
    
    public static double trainerAttack(String choice, double trainerAttack, double wildDefense, String wildType, double wildHp)
    {
        double damage;
        if(choice.equals("Tackle"))
        {
            damage = trainerAttack * 0.4 - (wildDefense / 5);
            wildHp = wildHp - damage;
            
        }
        else if(choice.equals("Ember"))
        {
            damage = trainerAttack * 0.5 - (wildDefense / 5);
            if(wildType.equals("Grass"))
            {
                damage = damage * 2;
            }
            else if(wildType.equals("Water"))
            {
                damage = damage / 2;
            }
            wildHp = wildHp - damage;
        }
        else if(choice.equals("Water Gun"))
        {
            damage = trainerAttack * 0.5 - (wildDefense / 5);
            if(wildType.equals("Fire"))
            {
                damage = damage * 2;
            }
            else if(wildType.equals("Grass"))
            {
                damage = damage / 2;
            }
            wildHp = wildHp - damage;
        }
        else if(choice.equals("Razor Leaf"))
        {
            damage = trainerAttack * 0.5 - (wildDefense / 5);
            if(wildType.equals("Water"))
            {
                damage = damage * 2;
            }
            else if(wildType.equals("Fire"))
            {
                damage = damage / 2;
            }
            wildHp = wildHp - damage;
        }
        return wildHp;
    }
    
    public static double roundAvoid(double value, int places) 
    {
    double scale = Math.pow(10, places);
    return Math.round(value * scale) / scale;
    }

    
    public static void sleep(int milliSeconds){
        try
        {
        Thread.sleep(milliSeconds);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    
    private static void typeWriter(String str){
        
        char ch = 'a';
        String result = "";
        
        for(int i = 0; i < str.length(); i++){
            
            ch = str.charAt(i);
            sleep(20);
            result += ch;
            System.out.print(ch);
            
        }
        
    }
    
    private static void type(String str){
        
        char ch = 'a';
        String result = "";
        
        for(int i = 0; i < str.length(); i++){
            
            ch = str.charAt(i);
            sleep(5);
            result += ch;
            System.out.print(ch);
            
        }
        
    }
    
    //Draw Pikachu.  
    public static void drawPikachu(){
        
        type("       \\:.             .:/\n");
        type("        \\``._________.''/ \n");
        type("         \\             / \n");
        type(" .--.--, / .':.   .':. \\\n");
        type("/__:  /  | '::' . '::' |\n");
        type("   / /   |`.   ._.   .'|\n");
        type("  / /    |.'         '.|\n");
        type(" /___-_-,|.\\  \\   /  /.|\n");
        type("      // |''\\.;   ;,/ '|\n");
        type("      `==|:=         =:|\n");
        type("         `.          .'\n");
        type("           :-._____.-:\n");
        type("          `''       `''\n");
        
    }
    
    //Draw Rattata.
    public static void drawRattata(){
        
        type("                                      ,'\"\"`--.\n");
        type("                                     |     __ `-.\n");
        type("                                     |    /  `.  `.\n");
        type("                                      \\        ,   `.\n");
        type("                                       `.      \\_    `.\n");
        type("                                         `.    | `.    \\\n");
        type("                                           `--\"    `.   `\n");
        type("                                                     `.  `\n");
        type("                 ,.._                                  \\  `\n");
        type("               /_,.  `.                                 \\  `\n");
        type("              j/   .   \\                  ___            \\  \\\n");
        type("              |    |   `____         _,--'   `.           .  L\n");
        type("               L  /`--\\\"'    `'--._ ,'   ,-`'\\ |           | |\n");
        type("                |-                /  ,''     ||            | |\n");
        type("     -v._      /                   ,'        ||            | |\n");
        type("       `.`-._,'               _     \\        |j    _,...   | |\n");
        type("         `,.'             _,-. \\     |      /,---\"\"     `- | |\n");
        type("        .'              ,\".   ||     `..___/,'            `' |\n");
        type("        |   ,         _/`-'  /,'                            `|\n");
        type("        |-.__.-'\"''\"\"' \"\"\"\"\"\"\"\"--`_,...-----''''--...--      `.\n");
        type("         `.____,..              \"\"   __,..---\"\"\"              |\n");
        type("          |       `              --\"'.                        `\n");
        type("          |     ,' `._                \\'                       `\n");
        type("          | |  .^.    `.             /                          `.\n");
        type("         ,'_]__|  \\   / `.          /          /____._            `._\n");
        type("       ,'          \\ j    '        /          /       `.             `.\n");
        type(" ___,.' `._       __L/    |     __'          /     _, / \\             |\n");
        type("`-._       L,.-\"\"\"  .    ,' _.-','          /-----'-./   `--.         |\n");
        type("   '   / ,'         '..'\"_,'    /         F /  .\"'_,'        |.__     '\n");
        type("  / ,.\\,'              \"\"      /         / (,'\\ .'        ,.-\"'  `.  j\n");
        type("  -'   '                      /        ,'     `\"         / __/' .- ,'\n");
        type("                           __.'\"`.    /                 `-' | _,L,'\n");
        type("                         .',      `\"\"'                      '/,--\n");
        type("                          / _..' _,,'\n");
        type("                          ,' `-\"' \n");
        
    }
    
    
    //Draw Bulbasaur.
    public static void drawBulbasaur(){
        
        type("             `;,;.;,;.;.'\n");
        type("        ..--''' '' ' ' '''--.  \n");
        type("      /' .   .'        '.   .`\\\n");
        type("     | /    /            \\   '.|\n");
        type("   .'| |   :             :    :|\n");
        type(" ,: /\\ \\.._\\ __..===..__/_../ /`.\n");
        type("|'' |  :.|  `'          `'  |.'  ::.\n");
        type("|   |  ''|    :'';          | ,  `''\\\n");
        type("|.:  \\/  | /'-.`'   ':'.-'\\ |  \\,   |\n");
        type("| '  /  /  | / |...   | \\ |  |  |';'|\n");
        type(" \\ _ |:.|  |_\\_|`.'   |_/_|  |.:| _ |\n");
        type("/,.,.|' \\__       . .      __/ '|.,.,\\\n");
        type("     | ':`.`----._____.---'.'   |\n");
        type("      \\   `:\"\"\"-------'\"\"' |   |\n");
        type("       ',-,-',             .'-=,=,\n\n");
        
    }
    
    //Draw Squirtle.
    public static void drawSquirtle(){
        
        type("               _,........__\n");
        type("            ,-'            \"`-.\n");
        type("          ,'                   `-.\n");
        type("        ,'                        \\\n");
        type("      ,'                           .\n");
        type("      .'\\               ,\\\"\\\".       `\n");
        type("     ._.'|             / |  `       \\\n");
        type("     |   |            `-.'  ||       `.\n");
        type("     |   |            '-._,'||       | \\\n");
        type("     .`.,'             `..,'.'       , |`-.\n");
        type("     l                       .'`.  _/  |   `.\n");
        type("     `-.._'-   ,          _ _'   -\" \\  .     `\n");
        type("`.\"\"\"\"\"'-.`-...,---------','         `. `....__.\n");
        type(".'        `\"-..___      __,'\\          \\  \\     \\\n");
        type("\\_ .          |   `\"\"\"\"'    `.           . \\     \\\n");
        type("  `.          |              `.          |  .     L\n");
        type("    `.        |`--...________.'.        j   |     |\n");
        type("      `._    .'      |          `.     .|   ,     |\n");
        type("         `--,\\       .            `7\"\"' |  ,      |\n");
        type("            ` `      `            /     |  |      |    _,-'\"\"\"`-.\n");
        type("             \\ `.     .          /      |  '      |  ,'          `.\n");
        type("              \\  v.__  .        '       .   \\    /| /              \\\n");
        type("               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |\n");
        type("                `        .        `._ ___,j.  `/ .-       ,---.     |\n");
        type("                ,`-.      \\         .\"     `.  |/        j     `    |\n");
        type("               /    `.     \\       /         \\ /         |     /    j\n");
        type("              |       `-.   7-.._ .          |\"          '         /\n");
        type("              |          `./_    `|          |            .     _,'\n");
        type("              `.           / `----|          |-............`---'\n");
        type("                \\          \\      |          |\n");
        type("               ,'           )     `.         |\n");
        type("                7____,,..--'      /          |\n");
        type("                                  `---.__,--.'\n");
        
    }
    
    //Draw Charmander.
    public static void drawCharmander(){
        
        type("              _.--\"\"`-..\n");
        type("            ,'          `.\n");
        type("          ,'          __  `.\n");
        type("         /|          \" __   \\\n");
        type("        , |           / |.   .\n");
        type("        |,'          !_.'|   |\n");
        type("      ,'             '   |   |\n");
        type("     /              |`--'|   |\n");
        type("    |                `---'   |\n");
        type("     .   ,                   |                       ,\".\n");
        type("      ._     '           _'  |                    , ' \\ `\n");
        type("  `.. `.`-...___,...---\"\"    |       __,.        ,`\"   L,|\n");
        type("  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \\\n");
        type("-:..     `. `-..--_.,.<       `\"      / `.        `-/ |   .\n");
        type("  `,         \"\"\"\"'     `.              ,'         |   |  ',,\n");
        type("    `.      '            '            /          '    |'. |/\n");
        type("      `.   |              \\       _,-'           |       ''\n");
        type("        `._'               \\   '\"\\                .      |\n");
        type("           |                '     \\                `._  ,'\n");
        type("           |                 '     \\                 .'|\n");
        type("           |                 .      \\                | |\n");
        type("           |                 |       L              ,' |\n");
        type("           `                 |       |             /   '\n");
        type("            \\                |       |           ,'   /\n");
        type("          ,' \\               |  _.._ ,-..___,..-'    ,'\n");
        type("         /     .             .      `!             ,j'\n");
        type("        /       `.          /        .           .'/\n");
        type("       .          `.       /         |        _.'.'\n");
        type("        `.          7`'---'          |------\"'_.'\n");
        type("       _,.`,_     _'                ,''-----\"'\n");
        type("   _,-_    '       `.     .'      ,\\\n");
        type("   -\" /`.         _,'     | _  _  _.|\n");
        type("    \"\"--'---\"\"\"\"\"'        `' '! |! /\n");
        
    }

    
}
