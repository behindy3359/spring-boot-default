const dtoResultBox = document.getElementById('dto-result-container');
const voResultBox = document.getElementById('vo-result-container');

// 폼 데이터를 쿼리 문자열로 만들어 GET /axios/res1 요청
function dtoRes1() {
  const form = document.getElementById('form_dto1');
  axios
    .get(`/axios/res1?name=${form.name.value}&age=${form.age.value}`)
    .then((res) => {
      console.log('dtoRes1: ', res.data);
      dtoResultBox.textContent = res.data;
    });
}

// 폼 데이터를 쿼리 문자열로 만들어 GET /axios/res2 요청
function dtoRes2() {
  const form = document.getElementById('form_dto1');
  axios
    .get(`/axios/res2?name=${form.name.value}&age=${form.age.value}`)
    .then((res) => {
      console.log('dtoRes2: ', res.data);
      dtoResultBox.textContent = res.data;
    });
}

function dtoRes3() {
  const form = document.getElementById('form_dto2');
  axios
    .post(`/axios/res3`, { name: form.name.value, age: form.age.value })
    .then((res) => {
      console.log('dtoRes3: ', res.data);
    })
    .catch((error) => {
      console.error('Error in dtoRes3:', error);
      dtoResultBox.textContent = error.message;
    });
}

function dtoRes4() {
  const form = document.getElementById('form_dto2');
  axios
    .post(`/axios/res4`, { name: form.name.value, age: form.age.value })
    .then((res) => {
      console.log('dtoRes1: ', res.data);
      dtoResultBox.textContent = res.data;
    });
}

function dtoRes5() {
  const form = document.getElementById('form_dto2');
  axios
    .post(`/axios/res5`, { name: form.name.value, age: form.age.value })
    .then((res) => {
      console.log('dtoRes5: ', res.data);
      dtoResultBox.textContent = res.data;
    });
}

function voRes1() {
  const form = document.getElementById('form_vo1');
  axios
    .get(`/axios/vo/res1?name=${form.name.value}&age=${form.age.value}`)
    .then((res) => {
      console.log('voRes1: ', res.data);
      voResultBox.textContent = res.data;
    });
}

function voRes2() {
  const form = document.getElementById('form_vo1');
  axios
    .get(`/axios/vo/res2?name=${form.name.value}&age=${form.age.value}`)
    .then((res) => {
      console.log('voRes2: ', res.data);
      voResultBox.textContent = res.data;
    });
}

function voRes3() {
  const form = document.getElementById('form_vo2');
  axios
    .post(`/axios/vo/res3`, { name: form.name.value, age: form.age.value })
    .then((res) => {
      console.log('voRes3: ', res.data);
    })
    .catch((error) => {
      console.error('Error in voRes3:', error);
      voResultBox.textContent = error.message;
    });
}

function voRes4() {
  const form = document.getElementById('form_vo2');
  axios
    .post(`/axios/vo/res4`, { name: form.name.value, age: form.age.value })
    .then((res) => {
      console.log('voRes4: ', res.data);
      voResultBox.textContent = res.data;
    });
}

function voRes5() {
  const form = document.getElementById('form_vo2');
  axios
    .post(`/axios/vo/res5`, { name: form.name.value, age: form.age.value })
    .then((res) => {
      console.log('voRes5 : ', res.data);
      voResultBox.textContent = res.data;
    });
}