**Important:** This project was developed prior to my adoption of Git and version control. As such, there is no commit history available.


<!-- About Game Section -->
# The Easiest Game

A game powered by JavaFx inspired by [The Hardest Game](https://www.crazygames.com/game/worlds-hardest-game) that provides the main functions you'd expect from a game such as leaderboards, shop to spend in game currrency, and multiple game levels.

<div align=center>
    <img alt=Home src=/images/home.png width=450px />
    <img alt=Home src=/images/gameplay.png width=450px />
</div>


<!-- Technologies used section -->
## Built With

* JavaFx
* Java
* CSS
* Gradle


<!-- Features section -->
## Features

* **Coin Collection:** Collect coins during gameplay.
* **Settings:** Customize your game experience.
    * Toggle the soundtrack on or off.
    * Control sound effects.
* **Instructions:** Learn how to play the game with a clear instructions page.
* **Leaderboards:** See the top 10 fastest game completion times.
* **Shop:** Use your coins to buy skins for your character.
* **Data Persistence:** Your progress matters! Specifically, the following is saved:
    * Number of coins collected.
    * Fastest completion times (for the leaderboards).
    * Skins purchased from the shop.


<!-- Getting started section -->
## Getting Started

### Prerequisites
* Gradle version 17.0.10


### Installation
1. Clone the repo:
   ```sh
   git clone https://github.com/georgesecen/the-easiest-game.git
   ```
2. Set value in coinCount.txt to 0 to reset player coins.
2. Remove all values in timeLeaderboard.txt to reset the leaderboards.


<!-- My contributions section -->
## My Contributions
What I personally contributed to this project.

### Shop And Coin Collection
<img alt=Shop src=/images/shop.png width=450px />

* Shop which allows player to purchase character skins using the coins they have acquired during gameplay. 

* Data persistence so the amount of coins collected is saved.

### Leaderboards and Time Tracking
<img alt=Leaderboards src=/images/leaderboards.png width=450px />

* Leaderboards which displays the top ten fastest game completion times. 
* Time tracking system to time how long it took player to complete the game, and saves the times.

### Settings
<img alt=Settings src=/images/settings.png width=450px />

* Settings gives player the ability to change the soundtrack and disable sound effects.


<!-- Authors section -->
## Authors
* [Wania Sharif](https://github.com/wania-sharif)
* [Cameron Mcrae](https://github.com/cmcrae1989)
* [George Secen](https://github.com/georgesecen)


<!-- License section -->
## License
<!-- This app is open-sourced software licensed under the [MIT license](https://choosealicense.com/licenses/mit/). -->


<!-- Acknowledgements section -->
## Acknowledgements
Special thanks to Câi Filiault for his lessons, advice and guidance.