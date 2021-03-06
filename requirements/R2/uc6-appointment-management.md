# ΠΧ6. Διαχείριση Ραντεβού
 
__Πρωτεύων Actor:__ Οδοντίατρος

__Ενδιαφερόμενοι:__ 

Οδοντίατρος: Ο οδοντίατρος έχει την δυνατότητα να δέχεται ή να απορρίπτει τα αιτήματα ραντεβόυ που του έχουν σταλεί.

Πελάτης: Κάνει την αίτηση ραντεβού και περιμένει επιβεβαίωση.

__Προϋποθέσεις:__ Ο πελάτης θα πρέπει να έχει πραγματοποιήσει με επιτυχία την περίπτωση χρήσης "Αίτηση Ραντεβού".

## Βασική Ροή

### Α) Επιβεβαίωση Ραντεβού
1. Μετά από την αίτηση ραντεβού ενός πελάτη, το σύστημα ειδοποιεί τον οδοντίατρο.
2. Ο οδοντίατρος δέχεται την αίτηση και "κλείνει" την συγκεκριμένη ημερομηνία στην προσωπική του ατζέντα.
3. Μετά από την επιβεβαίωση, η συγκεκριμένη ημερομηνία δεν είναι διαθέσιμη για άλλο ραντεβού.

### Β) Απόρριψη Ραντεβού
1. Μετά από την αίτηση ραντεβού ενός πελάτη, το σύστημα ειδοποιεί τον οδοντίατρο.
2. Ο οδοντίατρος απορρίπτει την αίτηση και το σύστημα στέλνει κατάλληλο μήνυμα στον ενδιαφερόμενο ή ειδοποιείται τηλεφωνικά.

### Εναλλακτικές Ροές

*1α. Απόρριψη Ραντεβού*
1. Ο οδοντίατρος αργεί να απαντήσει στη αίτηση, με αποτέλεσμα ο πελάτης να ειδοποιείται καταλλήλως (Μέσω e-mail ή τηλεφωνικά).

### Γ) Προβολή Ραντεβού 
1. Το σύστημα δίνει την επιλογή στον οδοντίατρο να δει την προσωπική του ατζέντα (Ώρες ραντεβού, ονόματα πελάτων).