const questions = [
    {
        question: "Qual a capital da França?",
        options: ["Paris", "Londres", "Berlim", "Madrid"],
        answer: "Paris"
    },
    {
        question: "Qual é a fórmula da água?",
        options: ["H2O", "CO2", "O2", "NaCl"],
        answer: "H2O"
    },
    {
        question: "Quem escreveu 'Dom Casmurro'?",
        options: ["Machado de Assis", "José de Alencar", "Clarice Lispector", "Jorge Amado"],
        answer: "Machado de Assis"
    },
    {
        question: "Qual é o maior planeta do sistema solar?",
        options: ["Terra", "Marte", "Júpiter", "Saturno"],
        answer: "Júpiter"
    },
    {
        question: "Em que ano o Brasil foi descoberto?",
        options: ["1500", "1498", "1600", "1800"],
        answer: "1500"
    },
    {
        question: "Qual é a moeda oficial do Japão?",
        options: ["Yuan", "Won", "Dólar", "Iene"],
        answer: "Iene"
    },
    {
        question: "Quem pintou a Mona Lisa?",
        options: ["Van Gogh", "Picasso", "Da Vinci", "Michelangelo"],
        answer: "Da Vinci"
    },
    {
        question: "Qual é a capital da Austrália?",
        options: ["Sydney", "Canberra", "Melbourne", "Brisbane"],
        answer: "Canberra"
    },
    {
        question: "Qual é o elemento químico com símbolo O?",
        options: ["Ouro", "Oxigênio", "Ósmio", "Oxônio"],
        answer: "Oxigênio"
    },
    {
        question: "Qual é o continente mais populoso do mundo?",
        options: ["África", "América do Norte", "Ásia", "Europa"],
        answer: "Ásia"
    }
];

let currentQuestionIndex = 0;
let score = 0;
let timer;

function startQuiz() {
    currentQuestionIndex = 0;
    score = 0;
    document.getElementById('result').classList.add('hidden');
    document.getElementById('next-button').classList.add('hidden'); // Oculta botão no início
    showQuestion();
}

function showQuestion() {
    resetTimer();
    
    const currentQuestion = questions[currentQuestionIndex];
    
    document.getElementById('question').innerText = currentQuestion.question;
    
    const optionsContainer = document.getElementById('options');
    optionsContainer.innerHTML = '';
    
    currentQuestion.options.forEach(option => {
        const button = document.createElement('button');
        button.innerText = option;
        button.onclick = () => selectOption(option);
        optionsContainer.appendChild(button);
    });
}

function selectOption(selectedOption) {
    const correctAnswer = questions[currentQuestionIndex].answer;
    
    const buttons = document.querySelectorAll('#options button');
    
    buttons.forEach(button => {
        if (button.innerText === correctAnswer) {
            button.classList.add('correct');
        } else {
            button.classList.add('incorrect');
            button.disabled = true; // Desabilita botões após resposta
        }
    });

    if (selectedOption === correctAnswer) {
        score++;
        alert("Correto!");
    } else {
        alert("Incorreto! A resposta correta é " + correctAnswer);
    }

    currentQuestionIndex++;

    // Verifica se ainda há perguntas
    if (currentQuestionIndex < questions.length) {
        document.getElementById('next-button').classList.remove('hidden'); // Mostra botão para próxima pergunta
    } else {
        showResult(); // Se não houver mais perguntas, mostra o resultado
    }
}

function showResult() {
    clearInterval(timer);
    
    const totalQuestions = questions.length;
    const correctAnswers = score;
    const wrongAnswers = totalQuestions - correctAnswers;

    document.getElementById('correct-answers').innerText = correctAnswers;
    document.getElementById('total-questions').innerText = totalQuestions;
    document.getElementById('wrong-answers').innerText = wrongAnswers;

    document.getElementById('result').classList.remove('hidden');
    
    // Exibe o botão de reiniciar
}

function resetTimer() {
   clearInterval(timer);
   
   let timeLeft = 15; // tempo em segundos
   document.getElementById('time').innerText = timeLeft;

   timer = setInterval(() => {
       timeLeft--;
       
       if (timeLeft <= 0) {
           clearInterval(timer);
           alert("Tempo esgotado! A resposta correta era " + questions[currentQuestionIndex].answer);
           currentQuestionIndex++;
           
           if (currentQuestionIndex < questions.length) {
               showQuestion();
           } else {
               showResult();
           }
       }
       
       document.getElementById('time').innerText = timeLeft;
       
   }, 1000);
}

function restartQuiz() {
   currentQuestionIndex = 0;
   score = 0;
   document.getElementById('result').classList.add('hidden');
   startQuiz();
}

// Adiciona evento ao botão de reiniciar
document.getElementById('restart-button').onclick = restartQuiz;

document.getElementById('next-button').onclick = () => {
   if (currentQuestionIndex < questions.length) { 
       showQuestion();
       document.getElementById('next-button').classList.add('hidden'); 
   }
};

startQuiz();