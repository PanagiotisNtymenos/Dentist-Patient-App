# Εισαγωγή
Απαιτήσεις Λογισμικού/Ανάλυση Συστήματος της Εφαρμογής Οδοντιατρίου.

### Μέλη Ομάδας
#### Φωτόπουλος Γεώργιος
#### Πατρίκης Γεώργιος
#### Ντυμένος Παναγιώτης

## Εμβέλεια
Το σύστημα υλοποιεί:

* Εγγραφή και διαχείριση λογαριασμού στον οδοντίατρο.
* Προβολή των στατιστικών του οδοντιάτρου.
* Εμφάνιση ιστορικού πελατών.
* Καταγραφή υπηρεσιών που παρήχε ο οδοντίατρος στον ασθενή.
* Δημιουργία προφίλ ασθενή από τον οδοντίατρο στην πρώτη επίσκεψη.
* Εμφάνιση αιτημάτων για ραντεβού και διαχείρησής τους.
* Καταγραφή ειδικοτήτων οδοντιάτρου.
* Καταγραφή εργασιών οδοντιάτρου.
* Αναζήτηση οδοντιάτρου μέσω φίλτρων.
* Φόρμα αίτησης για ραντεβού (χρήση από πελάτες).

Το σύστημα __δεν__ παρέχει:

* Δυνατότητα δημιουργίας λογαριασμού για τους πελάτες.
* Ζωντανή ενημέρωση για την κατάσταση της αίτησης για ραντεβού.
* Δυνατότητα εμφάνισης ιστορικού πελατών μεταξύ οδοντιάτρων και πελατών (Ο κάθε γιατρός μπορεί να δει μόνο το ιστορικό των πελατών του).
* Δυνατότητα στους γιατρούς να επιλέξουν ειδικότητα που δε βρίσκεται στη λίστα ειδικοτήτων.
* Πληροφορίες για πληρωμές ή ασφαλιστικά ταμεία.
___
### Διάγραμμα Ροής Δεδομένων - Επίπεδο 0
![](requirements/R2/drd0.png)

---
## Ορισμοί ακρώνυμα και συντομογραφίες

|Έννοια|Επεξήγηση|
|-----|---------|
|Στοιχεία Οδοντιάτρου|Κάθε λογαριασμός περιγράφεται από τα εξής: Όνομα, Επώνυμο, Άδεια Άσκησης Επαγγέλματος, Πανεπιστήμιο Φοίτησης, Τοποθεσία Ιατρείου, Χρόνια Προϋπηρεσίας Γιατρού, Τηλέφωνο Επικοινωνίας, Ηλεκτρονική Διεύθυνση και Κωδικός Πρόσβασης.|
|Διαχειριστής|Άτομο το οποίο καταγράφει τις ειδικότητες και τις εργασίες που πραγματοποιούν οι οδοντίατροι.|
|Πελάτης|Το άτομο το οποίο κλείνει ραντεβού και όχι αναγκαστικά αυτό που παρίσταται στο ραντεβού.|
|Υπηρεσίες|Περιγράφονται από μια λίστα με όλες τις διαθέσιμες εργασίες που πραγματοποιούνται στους ασθενείς.|
|Ραντεβού|Η αίτηση για ραντεβού περιγράφεται από τα εξής: Όνομα, Επώνυμο, Τηλέφωνο, Ηλεκτρονική Διεύθυνση, Λόγος Επίσκεψης (διαθέσιμες υπηρεσίες ή σχολιασμός άλλου).|
|Ατζέντα|Πρόκειται για την προσωπική ατζέντα του οδοντιάτρου η οποία περιλαμβάνει τα ραντεβού του.|
|Στατιστικά Υπηρεσιών Οδοντιάτρου| Ο αριθμός των επιτυχημένων υπηρεσιών που έχει πραγματοποιήσει για κάθε τύπο υπηρεσίας.|
|Στοιχεία Ασθενή|Περιλαμβάνει τα στοιχεία του πελάτη τα οποία καταχωρούνται κατά το ραντεβού του και είναι τα εξής: Όνομα, Επώνυμο, Διεύθυνση, Τηλέφωνο Επικοινωνίας, Ηλεκτρονική Διεύθυνση, ΑΜΚΑ.|
---
## Επισκόπηση

Ακολουθούν αναλυτικότερα παρακάτω οι:
* [Συνολική Περιγραφή](#συνολική-περιγραφή)
  * [Γενικό Μοντέλο Περιπτώσεων Χρήσης](#επισκόπηση-μοντέλου-περιπτώσεων-χρήσης)
  * [Υποθέσεις και Εξαρτήσεις](#υποθέσεις-και-εξαρτήσεις)
* [Ειδικές Απαιτήσεις](#ειδικές-απαιτήσεις)
  * [Περιπτώσεις Χρήσης](#περιπτώσεις-χρήσης)
  * [Συμπληρωματικές Προδιαγραφές](#συμπληρωματικές-προδιαγραφές)
* [Υποστηρικτικό Υλικό](#υποστηρικτικό-υλικό)
  * [Μοντέλο Πεδίου](#μοντέλο-πεδίου)
  * [Ανάλυση Περιπτώσεων Χρήσης](#ανάλυση-περιπτώσεων-χρήσης)
  * [Άλλα Μοντέλα](#άλλα-μοντέλα)

# Συνολική περιγραφή
## Επισκόπηση μοντέλου περιπτώσεων χρήσης

![](R1.png)

|Κωδικός|Τίτλος|Σύντομη Περιγραφή|
|-|-|-|
|ΠΧ1|Επίσκεψη Πελάτη|Η περίπτωση χρήσης όπου ο οδοντίατρος ελέγχει αν υπάρχει καρτέλα πελάτη στο σύστημα κατά την επίσκεψη κι αν δεν υπάρχει δημιουργεί μια με τα στοιχεία του. Εφόσον η καρτέλα υπάρχει, ο οδοντίατρος σημειώνει την υπηρεσία που παρείχε.|
|ΠΧ2|Προβολή Ιστορικού Πελάτη|Η περίπτωση χρήσης όπου ο οδοντίατρος αναζητεί για ένα συγκεκριμένο πελάτη το ιστορικό των υπηρεσιών που του έχουν παρασχεθεί.|
|ΠΧ3|Ταυτοποίηση Λογαριασμού|Η περίπτωση χρήσης κατά την οποία ο οδοντίατρος ταυτοποιείται από το σύστημα.|
|ΠΧ4|Δημιουργία & Διαχείριση Λογαριασμού|Η περίπτωση χρήσης όπου ο οδοντίατρος δύναται να δημιουργήσει λογαριασμό και να επεξεργαστεί τα δεδομένα του.|
|ΠΧ5|Στατιστικά Στοιχεία Εργασιών|Η περίπτωση χρήσης κατά την οποία ο οδοντίατρος ενημερώνει τις υπηρεσίες που έχει παράσχει.|
|ΠΧ6|Διαχείριση Ραντεβού|Η περίπτωση χρήσης όπου ο οδοντίατρος δέχεται ή απορρίπτει ένα ραντεβού.|
|ΠΧ7|Καταγραφή Ειδικοτήτων Οδοντιάτρων|Η περίπτωση χρήσης όπου ο διαχειριστής παράγει μια λίστα με όλες τις ειδικότητες οδοντιάτρων που είναι διαθέσιμες.|
|ΠΧ8|Καταγραφή Εργασιών Οδοντιάτρων|Η περίπτωση χρήσης όπου ο διαχειριστής παράγει μια λίστα με όλες τις διαθέσιμες εργασίες.|
|ΠΧ9|Αναζήτηση Οδοντιάτρου|Η περίπτωση χρήσης κατά την οποία ο πελάτης αναζητεί έναν οδοντίατρο.|
|ΠΧ10|Αίτηση Ραντεβού|Η περίπτωση χρήσης για την αίτηση ραντεβού στον οδοντίατρο που βρέθηκε μετά την αναζήτηση.|
---
## Υποθέσεις και εξαρτήσεις

|||
|-|-|
|Υποθέσεις Λειτουργικότητας Συστήματος|Η εφαρμογή απαιτεί να υπάρχει σύνδεση στο διαδίκτυο προκειμένου να υπάρχει συγχρονισμός δεδομένων και αιτημάτων.|
|Εξαρτήσεις από το περιβάλλον|Η εφαρμογή θα λειτουργεί μόνο σε κινητές συσκευές με λογισμικό Android.|
||Ο οδοντίατρος οφείλει να έχει διεύθυνση ηλεκτρονικού ταχυδρομείου, έτσι ώστε να μπορέσει να δημιουργήσει λογαριασμό.|

# Ειδικές Απαιτήσεις
## Περιπτώσεις χρήσης

### Οι ενδιαφερόμενοι και οι ανάγκες τους

|Ενδιαφερόμενος|Ανάγκες|
|--------------|-------|
|Πελάτης| Θέλει να κλείνει εύκολα και γρήγορα ραντεβού.|
|| Θέλει να ενημερώνεται για τους διάφορους οδοντιάτρους και τις ικανότητες τους.|
|| Να υπάρχει πάντα ένας διαθέσιμος οδοντίατρος.|
| Οδοντίατρος|Θέλει να αυξήσει την συχνότητα των ραντεβού που δέχεται.|
||Θέλει να γνωρίζει το ιστορικό υπηρεσιών που έχουν παρασχεθεί στον πέλατη που έκανε αίτηση για ραντεβού.|
||Θέλει να αποθηκεύει αποδοτικά τις υπηρεσίες που έχει πραγματοποιήσει.|
||Θέλει να γνωρίζει το πρόγραμμα του κάθε στιγμή.|
||Θέλει να είναι σίγουρος ότι τα ραντεβού του δεν θα επικαλύπτονται.|
---
### Actors του συστήματος

|Actor|Περιγραφή|Στόχοι|Ενδιαφερόμενοι|
|-|-|-|-|
|Οδοντίατρος|Ο βασικός χρήστης της εφαρμογής. Οδοντίατρος, ο οποίος έχει κάποια ειδικότητα και επιθυμεί να συμμετάσχει στο πρόγραμμα.|Διαχείριση Ατζέντας|Οδοντίατρος|
|||Διαχείριση Ραντεβού||
|||Διαχείριση Λογαριασμού||
|||Επίγνωση και καταγραφή των Προσωπικών του Στατιστικών Στοιχείων||
|Πελάτης| Οποιοσδήποτε ενδιαφέρεται να κλείσει ραντεβού|Κλείσιμο Ραντεβού|Πελάτης|
|||Εύρεση Οδοντιάτρου|
|Διαχειριστής|Είναι υπεύθυνος για την δημιουργία λίστας ειδικοτήτων και υπηρεσιών.|Διευκόλυνση Εγγραφής Οδοντιάτρων||
|||Διευκόλυνση Πελατών στην αναζήτηση Οδοντιάτρου||
---

### Περιγραφές περιπτώσεων χρήσης

[ΠΧ1 Επίσκεψη Πελάτη](uc1-client-visit.md)

[ΠΧ2 Προβολή Ιστορικού Πελάτη](uc2-show-client-history.md)

[ΠΧ3 Ταυτοποίηση Λογαριασμού](uc3-account-identification.md)

[ΠΧ4 Δημιουργία & Διαχείριση Λογαριασμού](uc4-account-registeration-and-management.md)

[ΠΧ5 Στατιστικά Στοιχεία Εργασιών](uc5-service-statistics.md)

[ΠΧ6 Διαχείριση Ραντεβού](uc6-appointment-management.md)

[ΠΧ7 Καταγραφή Ειδικοτήτων Οδοντιάτρων](uc7-dentist-specialization-registeration.md)

[ΠΧ8 Καταγραφή Εργασιών Οδοντιάτρων](uc8-dentist-service-registeration.md)

[ΠΧ9 Αναζήτηση Οδοντιάτρου](uc9-dentist-research.md)

[ΠΧ10 Αίτηση Ραντεβού](uc10-appointment-request.md)
___

## Συμπληρωματικές προδιαγραφές

### Απαιτήσεις διεπαφών
|||
|-|-|
|Διεπαφές Χρήστη|Όλες οι διεπαφές χρήστη θα είναι διαδικτυακές.|
||Υπάρχουν ειδικοί σύνδεσμοι που παρέχουν επεξηγήσεις για τη χρήση του εκάστοτε πλαισίου|
|Διεπαφές Υλικού|Το σύστημα χρησιμοποιεί το σύστημα αφής.|
|Διεπαφές Επικοινωνίας|Το σύστημα θα στέλνει ηλεκτρονικά μηνύματα για τις απαντήσεις στα αιτήματα ραντεβού.|
|Διεπαφές Λογισμικού|Το σύστημα χρησιμοποιεί δεδομένα από μια βάση δεδομένων για την προσθήκη οδοντιάτρων στο σύστημα αναζήτησης.|

### Περιορισμοί σχεδίασης και υλοποίησης

### Ποιοτικά χαρακτηριστικά
|||
|-|-|
|Απόδοση|Το σύστημα υποστηρίζει απεριόριστο αριθμό χρηστών.|
||Το σύστημα υποστηρίζει απεριόριστο αριθμό εγγραφών.|
|Διαθεσιμότητα|Το σύστημα θα είναι διαθέσιμο 24 ώρες την ημέρα, 7 ημέρες την εβδομάδα.|
||Τα ραντεβού θα είναι διαθέσιμα όλες τις εργάσιμες ώρες και ημέρες.|
|Ασφάλεια|Οι λειτουργίες αναζήτησης θα είναι ελεύθερες για κάθε ενδιαφερόμενο|
||Τα προσωπικά στοιχεία των εγγεγραμμένων οδοντιάτρων θα πραγματοποιούνται με διαδικασία αυθεντικοποίησης.|
|Ευελιξία|Απαιτείται ελάχιστος χρόνος για τη συντήρηση της εφαρμογής.|
|Ευχρηστία|Δεν υπάρχει προϋπόθεση για τον χρήστη της εφαρμογής να έχει κάποια προηγούμενη γνώση.|
___
# Υποστηρικτικό υλικό
## Μοντέλο πεδίου
![](montelo-pediou-2.png)
___

## Ανάλυση περιπτώσεων χρήσης
### Κλάσεις ανάλυσης
![](class-analysis.png)

### Συμπεριφορές
Τα διαγράμματα ακολουθίας για τις πιο σημαντικές περιπτώσεις χρήσης βρίσκονται στους παρακάτω συνδέσμους:

[ΠΧ1 Επίσκεψη Πελάτη](uc1-client-visit.md)

[ΠΧ4 Δημιουργία & Διαχείριση Λογαριασμού](uc4-account-registeration-and-management.md)

[ΠΧ9 Αναζήτηση Οδοντιάτρου](uc9-dentist-research.md)

#### Άνοιγμα νέου λογαριασμού
## Άλλα μοντέλα
![](state-machine.png)

## Επιχειρησιακοί κανόνες
|Επιχειρησιακοί Κανόνες|Περιγραφή|
|-|-|
|ΕΚ1|Το ΑΜΚΑ και η ηλεκτρονική διεύθυνση είναι μοναδικά για κάθε πελάτη.|
|ΕΚ2|Όλα τα στοιχεία του πελάτη είναι υποχρεωτικά.|
|ΕΚ3|Η ηλικία του πελάτη (που κλείνει το ραντεβού) θα πρέπει να είναι μεγαλύτερη των 18 ετών.|
|ΕΚ4|Η παρουσία του πελάτη στο ραντεβού που έκλεισε είναι υποχρεωτική, σε διαφορετική περίπτωση μπαίνει στη μαύρη λίστα.|
|ΕΚ5|Ένας πελάτης μπορεί να έχει ένα ή παραπάνω ενεργά ραντεβού ανά πάσα στιγμή.|
|ΕΚ6|Ένας οδοντίατρος δεν επιτρέπεται να έχει διπλά ραντεβού.|
___
