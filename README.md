# Treinmanagementsysteem 🚂

Een Java-applicatie voor het beheren van treinen, reizen, passagiers, personeel en tickets.

## 📋 Inhoudsopgave

- [Beschrijving](#beschrijving)
- [Functionaliteiten](#functionaliteiten)
- [Installatie](#installatie)
- [Gebruik](#gebruik)
- [Klassenstructuur](#klassenstructuur)
- [Relaties tussen klassen](#relaties-tussen-klassen)
- [Voorbeeldscenario](#voorbeeldscenario)

## 📖 Beschrijving

Het Treinmanagementsysteem is een console-applicatie waarmee je een compleet treinbedrijf kunt beheren. Je kunt treinen aanmaken, reizen plannen, passagiers en personeel koppelen, tickets uitgeven en boarding lijsten genereren.

## ✨ Functionaliteiten

### 1. Trein.Trein Beheer
- Nieuwe treinen aanmaken met locomotief
- Wagons toevoegen (Business of Economie klasse)
- Overzicht van alle treinen

### 2. Trein.Reis Beheer
- Nieuwe reizen aanmaken met vertrek- en aankomststations
- Vertrek- en aankomsttijden instellen
- Treinen koppelen aan reizen
- Overzicht van alle reizen

### 3. Persoon.Reiziger Beheer
- Nieuwe reizigers registreren
- Reizigers koppelen aan treinen
- Overzicht van alle reizigers

### 4. Persoon.Persoon.Personeel Beheer
- Persoon.Persoon.Personeel aanmaken (met functie en certificaat)
- Persoon.Persoon.Personeel toewijzen aan treinen
- Overzicht van al het personeel

### 5. Persoon.Ticket Beheer
- Tickets uitgeven met ticketnummer en prijs
- Tickets koppelen aan reizigers en reizen
- Overzicht van alle tickets

### 6. Boarding Lijst
- **Professionele boarding lijst genereren in .txt formaat**
- Bevat trein-, reis- en passagiersinformatie
- Exporteerbaar voor afdrukken

## 🔧 Installatie

### Vereisten
- Java JDK 8 of hoger
- Een Java IDE (IntelliJ IDEA, Eclipse, VS Code) of terminal

### Stappen

1. **Download de code**
   ```bash
   # Clone of download het project
   ```

2. **Compileer het programma**
   ```bash
   javac TreinManagementSysteem.java
   ```

3. **Run het programma**
   ```bash
   java TreinManagementSysteem
   ```

## 🎮 Gebruik

### Hoofdmenu

Bij het starten zie je het hoofdmenu:

```
========== TREINMANAGEMENTSYSTEEM ==========
1. Trein.Trein beheer
2. Trein.Reis beheer
3. Persoon.Reiziger beheer
4. Persoon.Persoon.Personeel beheer
5. Persoon.Ticket beheer
6. Toon alle informatie
7. Boarding lijst afdrukken (txt)
0. Afsluiten
```

### Typische workflow

1. **Maak een trein aan** (optie 1)
   - Kies type motor (bijv. Elektrisch, Diesel)
   - Voeg wagons toe met klasse en capaciteit

2. **Maak een reis aan** (optie 2)
   - Voer vertrek- en aankomststation in
   - Stel tijden in
   - Koppel de trein aan de reis

3. **Maak personeel aan** (optie 4)
   - Voer naam, functie en certificaat in
   - Wijs personeel toe aan de trein

4. **Registreer reizigers** (optie 3)
   - Voer naam en familienaam in
   - Koppel reiziger aan trein

5. **Geef tickets uit** (optie 5)
   - Maak ticket met nummer en prijs
   - Koppel aan reiziger en reis

6. **Genereer boarding lijst** (optie 7)
   - Selecteer een trein
   - Geef bestandsnaam op
   - Lijst wordt opgeslagen als .txt bestand

## 🏗️ Klassenstructuur

### Overerving (Inheritance)

```
Persoon.Persoon (abstract superklasse)
├── Persoon.Reiziger
└── Persoon.Persoon.Personeel
```

**Persoon.Persoon**
- Attributen: naam, familienaam
- Gemeenschappelijke eigenschappen van alle mensen

**Persoon.Reiziger** (extends Persoon.Persoon)
- Erft: naam, familienaam
- Relaties: heeft 1 Persoon.Ticket, zit op 1 Trein.Trein

**Persoon.Persoon.Personeel** (extends Persoon.Persoon)
- Erft: naam, familienaam
- Attributen: functie, certificaat
- Relatie: werkt op 1 Trein.Trein

### Compositie (Composition)

**Trein.Trein**
- Bestaat uit: 1 Trein.Trein.Locomotief + meerdere Wagons
- Bevat: meerdere Personeelsleden, meerdere Reizigers
- Heeft: 1 Trein.Reis

**Trein.Trein.Locomotief**
- Attributen: typeMotor

**Trein.Trein.Wagon**
- Attributen: typeKlasse (enum: BUSINESS, ECONOMIE), capaciteit

**Trein.Reis**
- Attributen: vertrekStation, aankomstStation, vertrekTijd, aankomstTijd
- Relatie: heeft 1 Trein.Trein, heeft meerdere Tickets

**Persoon.Ticket**
- Attributen: ticketNummer, prijs
- Relaties: hoort bij 1 Persoon.Reiziger, geldig voor 1 Trein.Reis

## 🔗 Relaties tussen klassen

| Relatie | Type | Beschrijving |
|---------|------|-------------|
| Persoon.Reiziger ↔ Persoon.Ticket | 1:1 | Een reiziger heeft precies één ticket |
| Persoon.Persoon.Personeel → Trein.Trein | N:1 | Meerdere personeelsleden werken op één trein |
| Persoon.Reiziger → Trein.Trein | N:1 | Meerdere reizigers zitten op één trein |
| Trein.Trein ↔ Trein.Reis | 1:1 | Een trein heeft één reis |
| Persoon.Ticket → Trein.Reis | N:1 | Meerdere tickets voor één reis |
| Trein.Trein → Trein.Trein.Locomotief | 1:1 | Een trein heeft één locomotief (compositie) |
| Trein.Trein → Trein.Trein.Wagon | 1:N | Een trein heeft meerdere wagons (compositie) |

## 📝 Voorbeeldscenario

```
SCENARIO: Brussel → Amsterdam

1. Trein.Trein aanmaken
   - Trein.Trein.Locomotief: Elektrisch
   - Trein.Trein.Wagon 1: Business (50 plaatsen)
   - Trein.Trein.Wagon 2: Economie (100 plaatsen)
   - Trein.Trein.Wagon 3: Economie (100 plaatsen)

2. Trein.Reis plannen
   - Van: Brussel
   - Naar: Amsterdam
   - Vertrek: 10:00
   - Aankomst: 13:30

3. Persoon.Persoon.Personeel toewijzen
   - Jan Janssen (Machinist, Certificaat A)
   - Piet Pieters (Conducteur, Certificaat B)
   - Lisa Smits (Service, Certificaat C)

4. Reizigers registreren
   - Marie Dupont → Persoon.Ticket T001 (€45.50)
   - Tom De Vries → Persoon.Ticket T002 (€45.50)
   - Anna Bakker → Persoon.Ticket T003 (€65.00, Business)

5. Boarding lijst genereren
   - Bestand: brussel_amsterdam_boarding.txt
   - Bevat alle passagiers met ticketinfo
```

## 📄 Outputvoorbeeld (Boarding Lijst)

```
═══════════════════════════════════════════════════════
              BOARDING LIJST - PASSAGIERS              
═══════════════════════════════════════════════════════

TREIN INFORMATIE:
─────────────────────────────────────────────────────
Trein.Trein.Locomotief: Elektrisch
Aantal wagons: 3

WAGONS:
  Trein.Trein.Wagon 1: BUSINESS (Capaciteit: 50)
  Trein.Trein.Wagon 2: ECONOMIE (Capaciteit: 100)
  Trein.Trein.Wagon 3: ECONOMIE (Capaciteit: 100)

REIS INFORMATIE:
─────────────────────────────────────────────────────
Van: Brussel
Naar: Amsterdam
Vertrek: 10:00
Aankomst: 13:30

PASSAGIERS:
─────────────────────────────────────────────────────
Nr.   Voornaam             Familienaam          Persoon.Ticket Nr.      Prijs     
─────────────────────────────────────────────────────
1     Marie                Dupont               T001            €45.50    
2     Tom                  De Vries             T002            €45.50    
3     Anna                 Bakker               T003            €65.00    

Totaal aantal passagiers: 3

═══════════════════════════════════════════════════════
         Gegenereerd door Treinmanagementsysteem       
═══════════════════════════════════════════════════════
```

## 🛠️ Technische details

- **Taal**: Java
- **Versie**: Compatible met Java 8+
- **Design patterns**: 
  - Inheritance (Persoon.Persoon → Persoon.Reiziger/Persoon.Persoon.Personeel)
  - Composition (Trein.Trein bevat Trein.Trein.Locomotief en Wagons)
  - Enum (Trein.TypeKlasse voor wagons)
- **Features**:
  - Bidirectionele relaties (automatische updates)
  - Input validatie
  - File I/O voor boarding lijsten
  - Menu-driven interface

## 👨‍💻 Auteur

Benkirane Rakim

Gemaakt als onderdeel van een Java-leerproject.

## 🤖 AI-ondersteuning

Dit project is ontwikkeld met ondersteuning van Claude (Anthropic AI). 

## 📜 Licentie

Vrij te gebruiken voor educatieve doeleinden.

---

**Veel plezier met het beheren van je treinen! 🚄**
