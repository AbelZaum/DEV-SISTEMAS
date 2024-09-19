const board = document.getElementById('board');
const movesDisplay = document.getElementById('moves');
const timerDisplay = document.getElementById('timer');
const restartBtn = document.getElementById('restart');

let cards = [
  '🍎', '🍎', '🍌', '🍌',
  '🍇', '🍇', '🍒', '🍒',
  '🍉', '🍉', '🍓', '🍓',
  '🍍', '🍍', '🍑', '🍑'
];

let flippedCards = [];
let matchedCards = [];
let moves = 0;
let lockBoard = false;
let time = 0;
let timer; // Variável para armazenar o temporizador

// Função para iniciar o jogo
function startGame() {
  board.innerHTML = '';
  shuffledCards = shuffle(cards);
  moves = 0;
  time = 0;
  movesDisplay.textContent = moves;
  timerDisplay.textContent = time;
  flippedCards = [];
  matchedCards = [];
  clearInterval(timer); // Resetar o temporizador ao reiniciar o jogo
  startTimer(); // Iniciar o temporizador
  createBoard();
}

// Função para criar o tabuleiro
function createBoard() {
  shuffledCards.forEach((card) => {
    const cardElement = document.createElement('div');
    cardElement.classList.add('card');
    cardElement.innerHTML = `
      <div class="card-front">${card}</div>
      <div class="card-back"></div>
    `;
    cardElement.addEventListener('click', flipCard);
    board.appendChild(cardElement);
  });
}

// Função para embaralhar as cartas
function shuffle(array) {
  return array.sort(() => Math.random() - 0.5);
}

// Função para virar a carta
function flipCard() {
  if (lockBoard || this.classList.contains('flip')) return;

  this.classList.add('flip');
  flippedCards.push(this);

  if (flippedCards.length === 2) {
    lockBoard = true;
    checkForMatch();
  }
}

// Função para verificar correspondência
function checkForMatch() {
  const [firstCard, secondCard] = flippedCards;

  if (firstCard.innerHTML === secondCard.innerHTML) {
    disableCards();
    matchedCards.push(firstCard, secondCard);
    checkForWin();
  } else {
    unflipCards();
  }

  moves++;
  movesDisplay.textContent = moves;
}

// Desabilitar as cartas correspondentes
function disableCards() {
  flippedCards.forEach(card => card.removeEventListener('click', flipCard));
  resetBoard();
}

// Desvirar as cartas se não houver correspondência
function unflipCards() {
  setTimeout(() => {
    flippedCards.forEach(card => card.classList.remove('flip'));
    resetBoard();
  }, 1000);
}

// Resetar o tabuleiro
function resetBoard() {
  flippedCards = [];
  lockBoard = false;
}

// Verificar se todas as cartas foram encontradas
function checkForWin() {
  if (matchedCards.length === cards.length) {
    clearInterval(timer); // Parar o temporizador ao final do jogo
    setTimeout(() => {
      alert(`Você venceu! Tempo: ${time} segundos | Jogadas: ${moves}`);
      startGame();
    }, 500);
  }
}

// Função para iniciar o temporizador
function startTimer() {
  timer = setInterval(() => {
    time++;
    timerDisplay.textContent = time;
  }, 1000); // Atualiza a cada segundo
}

// Reiniciar o jogo
restartBtn.addEventListener('click', startGame);

// Iniciar o jogo na primeira vez
startGame();
