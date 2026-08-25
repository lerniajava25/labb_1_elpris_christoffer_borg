import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

void main() {
    String n;
    int option;
    String area = null;
    String newArea;
    //minMaxAverage = null;
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
                newArea = selectArea(input);
                if (newArea != null) {
                    area = newArea;
                    api(area);
                }
                break;
            case 2:
                if (area != null) {
                //minMaxAverage = calculateMinMaxAverage();
                }
                else {
                    IO.println("Du måste välja ett elområde först.");
                }
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
    } while (true);

}

void calculateMinMaxAverage () {

}

void api (String area) {
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM-dd");
    String formattedDate = date.format(formatter);

    HttpResponse<String> response;
    try (HttpClient client = HttpClient.newHttpClient()) {
        URI uri = URI.create("https://www.elprisetjustnu.se/api/v1/prices/" + formattedDate + "_" + area + ".json");
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        builder.uri(uri);
        HttpRequest request = builder.build();
        response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            IO.println("Anropet misslyckades.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            IO.println("Anropet avbröts.");
        }
    }
    if (response != null) {
        IO.println(response.statusCode() + response.body());
    }
}

String selectArea (Scanner input) {
    String n;
    int option;
    do {
        IO.println("Välj elområde");
        IO.println("=============");
        IO.println("1. SE1 - Luleå / Norra Sverige");
        IO.println("2. SE2 - Sundsvall / Norra Mellansverige");
        IO.println("3. SE3 - Stockholm / Södra Mellansverige");
        IO.println("4. SE4 - Malmö / Södra Sverige");
        IO.println("e. Tillbaka");
        IO.println("=============");
        IO.print("Välj ett alternativ ");

        n = input.nextLine();
        if (n.equals("e") || n.equals("E")) {
            return null;
        }
        try {
            option = Integer.parseInt(n);
        } catch (NumberFormatException e) {
            IO.print("Du måste ange ett nummer mellan 1-4 eller e för att gå tillbaka: \n");
            continue;
        }
        switch (option) {
            case 1:
                return "SE1";
            case 2:
                return "SE2";
            case 3:
                return "SE3";
            case 4:
                return "SE4";
            default:
                IO.print("Du måste ange ett nummer mellan 1-4 eller e för att avsluta: \n");

        }
    } while (true);
}
