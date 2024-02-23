
package tn.valorant.valorblog.gestion_evenement;


import java.util.List;

public class EvenementController {
    private List<Evenement> events;
    public EvenementController() {
        this.events = new ArrayList<>();
    }


    public void ajouterEvenement(Evenement event) {
        events.add(event);

    }




   //AFFICHER LES EVENEMENTS
    public List<Evenement> getEvents() {
           return events;
        }


    public void supprimerEvenement(Evenement event) {
        events.remove(event);
    }

    public void updateEvent(Evenement updatedEvent) {
        for (Evenement event : events) {
            if (event.getId() == updatedEvent.getId()) {
                event.setName(updatedEvent.getName());
                event.setDate(updatedEvent.getDate());
                event.setDescription(updatedEvent.getDescription());
                break;
            }
        }
    }
}

