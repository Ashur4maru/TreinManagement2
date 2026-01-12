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

### 1. Trein Beheer
- Nieuwe treinen aanmaken met locomotief
- Wagons toevoegen (Business of Economie klasse)
- Overzicht van alle treinen

### 2. Reis Beheer
- Nieuwe reizen aanmaken met vertrek- en aankomststations
- Vertrek- en aankomsttijden instellen
- Treinen koppelen aan reizen
- Overzicht van alle reizen

### 3. Reiziger Beheer
- Nieuwe reizigers registreren
- Reizigers koppelen aan treinen
- Overzicht van alle reizigers

### 4. Personeel Beheer
- Personeel aanmaken (met functie en certificaat)
- Personeel toewijzen aan treinen
- Overzicht van al het personeel

### 5. Ticket Beheer
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
1. Trein beheer
2. Reis beheer
3. Reiziger beheer
4. Personeel beheer
5. Ticket beheer
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
Persoon (abstract superklasse)
├── Reiziger
└── Personeel
```

**Persoon**
- Attributen: naam, familienaam
- Gemeenschappelijke eigenschappen van alle mensen

**Reiziger** (extends Persoon)
- Erft: naam, familienaam
- Relaties: heeft 1 Ticket, zit op 1 Trein

**Personeel** (extends Persoon)
- Erft: naam, familienaam
- Attributen: functie, certificaat
- Relatie: werkt op 1 Trein

### Compositie (Composition)

**Trein**
- Bestaat uit: 1 Locomotief + meerdere Wagons
- Bevat: meerdere Personeelsleden, meerdere Reizigers
- Heeft: 1 Reis

**Locomotief**
- Attributen: typeMotor

**Wagon**
- Attributen: typeKlasse (enum: BUSINESS, ECONOMIE), capaciteit

**Reis**
- Attributen: vertrekStation, aankomstStation, vertrekTijd, aankomstTijd
- Relatie: heeft 1 Trein, heeft meerdere Tickets

**Ticket**
- Attributen: ticketNummer, prijs
- Relaties: hoort bij 1 Reiziger, geldig voor 1 Reis

## 🔗 Relaties tussen klassen

| Relatie | Type | Beschrijving |
|---------|------|-------------|
| Reiziger ↔ Ticket | 1:1 | Een reiziger heeft precies één ticket |
| Personeel → Trein | N:1 | Meerdere personeelsleden werken op één trein |
| Reiziger → Trein | N:1 | Meerdere reizigers zitten op één trein |
| Trein ↔ Reis | 1:1 | Een trein heeft één reis |
| Ticket → Reis | N:1 | Meerdere tickets voor één reis |
| Trein → Locomotief | 1:1 | Een trein heeft één locomotief (compositie) |
| Trein → Wagon | 1:N | Een trein heeft meerdere wagons (compositie) |

## 📝 Voorbeeldscenario

```
SCENARIO: Brussel → Amsterdam

1. Trein aanmaken
   - Locomotief: Elektrisch
   - Wagon 1: Business (50 plaatsen)
   - Wagon 2: Economie (100 plaatsen)
   - Wagon 3: Economie (100 plaatsen)

2. Reis plannen
   - Van: Brussel
   - Naar: Amsterdam
   - Vertrek: 10:00
   - Aankomst: 13:30

3. Personeel toewijzen
   - Jan Janssen (Machinist, Certificaat A)
   - Piet Pieters (Conducteur, Certificaat B)
   - Lisa Smits (Service, Certificaat C)

4. Reizigers registreren
   - Marie Dupont → Ticket T001 (€45.50)
   - Tom De Vries → Ticket T002 (€45.50)
   - Anna Bakker → Ticket T003 (€65.00, Business)

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
Locomotief: Elektrisch
Aantal wagons: 3

WAGONS:
  Wagon 1: BUSINESS (Capaciteit: 50)
  Wagon 2: ECONOMIE (Capaciteit: 100)
  Wagon 3: ECONOMIE (Capaciteit: 100)

REIS INFORMATIE:
─────────────────────────────────────────────────────
Van: Brussel
Naar: Amsterdam
Vertrek: 10:00
Aankomst: 13:30

PASSAGIERS:
─────────────────────────────────────────────────────
Nr.   Voornaam             Familienaam          Ticket Nr.      Prijs     
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
  - Inheritance (Persoon → Reiziger/Personeel)
  - Composition (Trein bevat Locomotief en Wagons)
  - Enum (TypeKlasse voor wagons)
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
