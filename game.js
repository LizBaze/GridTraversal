window.addEventListener("load", init);

var playerHealth = 100;
var playerMoves = 150;

function init(e) {
  gridGenerator();
  window.addEventListener("keydown", movePlayer);
}

function gridGenerator() {
  let grid = Array.from(Array(50), () => new Array(50));

  for (let row of grid) {
    for (let i = 0; i < row.length; i++) {
      row[i] = Math.floor(Math.random() * 7) + 1;
    }
  }
  gridPrinter(grid);
}

function gridPrinter(grid) {
  let gridContainer = document.getElementById("gridContainer");
  let start = Math.floor(Math.random() * 50);
  let end = Math.floor(Math.random() * 50);

  for (let i = 0; i < grid.length; i++) {
    let tr = document.createElement("tr");
    for (let j = 0; j < grid[i].length; j++) {
      let td = document.createElement("td");
      let tileContainer = document.createElement("img");
      if (j === 0 && i === start) {
        tileContainer.id = "player";
        tileContainer.yPos = i;
        tileContainer.xPos = j;
        tileContainer.src =
          "https://cdn.discordapp.com/attachments/681409835446698007/1068994805356568736/R8FhH3pzAVc0AAAAABJRU5ErkJggg.png";
      } else if (i === end && j === grid.length - 1) {
        tileContainer.id = j + ", " + i;
        tileContainer.type = "end";
        tileContainer.src =
          "https://thumbs.dreamstime.com/b/bold-red-letter-sign-shape-stock-vector-illustration-clip-art-graphics-bold-red-letter-sign-shape-241934821.jpg";
      } else {
        tileContainer.id = j + ", " + i;
        switch (grid[i][j]) {
          case 1:
            tileContainer.type = "lava";
            tileContainer.src =
              "https://cdn.discordapp.com/attachments/681409835446698007/1068981263249199187/2Q.png";
            break;
          case 2:
            tileContainer.type = "mud";
            tileContainer.src =
              "https://st2.depositphotos.com/2225062/10009/v/450/depositphotos_100091406-free-stock-illustration-ground-pattern-pixel-art-illustration.jpg";
            break;
          case 3:
            tileContainer.type = "speeder";
            tileContainer.src =
              "https://cdn.discordapp.com/attachments/681409835446698007/1068982876739223693/Screen_Shot_2023-01-28_at_1.55.29_PM.png";
            break;
          case 4:
            tileContainer.type = "blank";
            tileContainer.src =
              "https://cdn.discordapp.com/attachments/681409835446698007/1068982398156554270/9k.png";
            break;
          case 5:
            tileContainer.type = "blank";
            tileContainer.src =
              "https://cdn.discordapp.com/attachments/681409835446698007/1068982398156554270/9k.png";
            break;
          case 6:
            tileContainer.type = "blank";
            tileContainer.src =
              "https://cdn.discordapp.com/attachments/681409835446698007/1068982398156554270/9k.png";
            break;
          case 7:
            tileContainer.type = "blank";
            tileContainer.src =
              "https://cdn.discordapp.com/attachments/681409835446698007/1068982398156554270/9k.png";
            break;
        }
      }
      tileContainer.style.height = "12px";
      tileContainer.style.width = "12px";
      tr.appendChild(tileContainer);

      gridContainer.appendChild(tr);
    }
  }
}

function movePlayer(e) {
  e.preventDefault();
  let player = document.getElementById("player");
  console.log(player.xPos + ", " + player.yPos);
  let newPos = undefined;
  if (e.key === "ArrowLeft" && player.xPos !== 0) {
    newPos = document.getElementById(player.xPos - 1 + ", " + player.yPos);
    console.log(newPos);
    newPos.xPos = player.xPos - 1;
    newPos.yPos = player.yPos;
    player.id = "";
    newPos.id = "player";
    newPos.src =
      "https://cdn.discordapp.com/attachments/681409835446698007/1068994805356568736/R8FhH3pzAVc0AAAAABJRU5ErkJggg.png";
  } else if (e.key === "ArrowRight" && player.xPos !== 49) {
    newPos = document.getElementById(player.xPos + 1 + ", " + player.yPos);
    console.log(newPos);
    console.log(newPos.type);
    newPos.xPos = player.xPos + 1;
    newPos.yPos = player.yPos;
    player.id = "";
    newPos.id = "player";
    newPos.src =
      "https://cdn.discordapp.com/attachments/681409835446698007/1068994805356568736/R8FhH3pzAVc0AAAAABJRU5ErkJggg.png";
  } else if (e.key === "ArrowUp" && parseInt(player.yPos) !== 0) {
    newPos = document.getElementById(player.xPos + ", " + (player.yPos - 1));
    console.log(newPos);
    console.log(newPos.type);
    newPos.xPos = player.xPos;
    newPos.yPos = player.yPos - 1;
    player.id = "";
    newPos.id = "player";
    newPos.src =
      "https://cdn.discordapp.com/attachments/681409835446698007/1068994805356568736/R8FhH3pzAVc0AAAAABJRU5ErkJggg.png";
  } else if (e.key === "ArrowDown" && player.yPos !== 49) {
    newPos = document.getElementById(player.xPos + ", " + (player.yPos + 1));
    console.log(newPos);
    console.log(newPos.type);
    newPos.xPos = player.xPos;
    newPos.yPos = player.yPos + 1;
    player.id = "";
    newPos.id = "player";
    newPos.src =
      "https://cdn.discordapp.com/attachments/681409835446698007/1068994805356568736/R8FhH3pzAVc0AAAAABJRU5ErkJggg.png";
  }

  switch (newPos.type) {
    case "lava":
      playerHealth -= 50;
      playerMoves -= 10;
      break;
    case "mud":
      playerHealth -= 10;
      playerMoves -= 5;
      break;
    case "speeder":
      playerHealth -= 5;
      break;
    case "blank":
      playerMoves--;
      break;
    case "end":
      window.removeEventListener("keydown", movePlayer);
      let gameover = document.getElementById("gameover");
      gameover.textContent = "You win!";
  }
  let health = document.getElementById("health");
  health.textContent = "Health: " + playerHealth;
  let moves = document.getElementById("moves");
  moves.textContent = "Moves: " + playerMoves;
  if (playerHealth <= 0 || playerMoves <= 0) {
    window.removeEventListener("keydown", movePlayer);
    let gameover = document.getElementById("gameover");
    gameover.textContent = "Game over!";
  }
  console.log(playerHealth + " " + playerMoves);
}
