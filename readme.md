### Database-luokat:

**AlbumDao**

Album-taulussa tehtävät tietokantaoperaatiot artistin albumien hakemiseksi ja albumien etsimiseksi.

**ArtistDao**

Artist-taulussa tehtävät tietokantaoperaatiot kaikkien artistien hakeminen, artistin lisääminen, artistien etsiminen ja artistin nimen hakeminen id:llä.

**Database**

Tietokanta yhteyden avaaminen ja sulkeminen.

### Model-luokat

**Album**

Kuvaa album olion.

**Artist**

Kuvaa artist olion.

### Servlet-luokat

**ArtistListServlet**

Välittää jsp-sivulle listan kaikista tietokannan artisteista. Lisää käyttäjän antaman artistin tietokantaan ja välittää tiedon operaation onnistumisesta sivulle. Ohjaa hakutulos sivulle käytettäessä hakulomaketta.

**AlbumListServlet**

Välittää jsp-sivulle listan parametrina annetun artistin albumeista. Ohjaa hakutulos sivulle käytettäessä hakulomaketta.

**SearchServlet**

Välittää jsp-sivulle hakutermiä vastaavat artistit, albumit ja albumeja vastaavat artistit. Ohjaa hakutulos sivulle käytettäessä hakulomaketta.

### JSP-sivut

**artistlist**

Näyttää selaimessa servletiltä saadut artistit sekä lomakkeet artistin lisäämiseksi ja hakujen tekemiseksi. Näyttää viestin artistin lisäämisen onnistumisesta tai epäonnistumisesta lisäämisen jälkeen.

**albumlist**

Näyttää selaimessa servletiltä saadut artistin kaikki albumit, jos artistilla ei ole albumeita näyttää viestin "artistilla ei ole albumeita". Näyttää lomakkeen hakujen tekemiseksi.

**searchresults**

Näyttää hakutermiä vastaavat artistit ja albumit sekä jokaisen albumin artistin. Jos hakutermillä ei ole tuloksia näyttää viestin "termillä ei löytynyt albumeita/artisteja". Näyttää lomakkeen hakujen tekemiseksi.
  
## 
[Projektipohja](https://github.com/ohjelmointi2/embedded-tomcat-template)  
[Tietokanta](https://github.com/lerocha/chinook-database)  
[CSS](https://github.com/oxalorg/sakura)