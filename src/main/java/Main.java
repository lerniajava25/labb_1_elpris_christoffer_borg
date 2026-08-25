void main() {
    String n;
    int option = 0;
    Scanner input = new Scanner(System.in);
    do {
        IO.println("Elpriser - Analysverktyg");
        IO.println("========================");
        IO.println("1. Välj elområde (SE1, SE2, SE3, SE4)");
        IO.println("2. Min, Max och Medelpris");
        IO.println("3. Sortera priser (lägst till högst)");
        IO.println("4. Bästa laddningstid (4h sammanhängande");
        IO.println("e. Avsluta");
        IO.println("========================");
        IO.print("Välj ett alternativ ");

        n = input.nextLine();
        if (n.equals("e") || n.equals("E")) {
            break;
        }
        try {
            option = Integer.parseInt(n);
        } catch (NumberFormatException e) {
            IO.print("Du måste ange ett nummer mellan 1-4 eller e för att avsluta: \n");
            continue;
        }
        switch (option) {
            case 1:
                api();
                break;
            case 2:
                IO.println("Du valde alternativ 2.");
                break;
            case 3:
                IO.println("Du valde alternativ 3.");
                break;
            case 4:
                IO.println("Du valde alternativ 4.");
                break;
            default:
                IO.print("Du måste ange ett nummer mellan 1-4 eller e för att avsluta: \n");

        }
    } while (option < 1 || option > 4);

}

void api () {
    IO.println("Det funkar!");
}
