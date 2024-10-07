document.addEventListener('DOMContentLoaded', function() {
    const yearSelect = document.getElementById('year');
    const monthSelect = document.getElementById('month');
    const dateSelect = document.getElementById('date');

    // 년도 옵션 생성 (1900년부터 현재 년도까지)
    const currentYear = new Date().getFullYear();
    for (let i = currentYear; i >= 1900; i--) {
        const option = document.createElement('option');
        option.value = i;
        option.textContent = i + '년';
        yearSelect.appendChild(option);
    }

    // 월 옵션 생성
    for (let i = 1; i <= 12; i++) {
        const option = document.createElement('option');
        option.value = i;
        option.textContent = i + '월';
        monthSelect.appendChild(option);
    }

    // 일 옵션 생성 함수
    function populateDays() {
        dateSelect.innerHTML = '<option value="" disabled selected>일</option>';
        const year = yearSelect.value;
        const month = monthSelect.value;
        
        if (year && month) {
            const daysInMonth = new Date(year, month, 0).getDate();
            for (let i = 1; i <= daysInMonth; i++) {
                const option = document.createElement('option');
                option.value = i;
                option.textContent = i + '일';
                dateSelect.appendChild(option);
            }
        }
    }

    // 년도나 월 선택 시 일 옵션 업데이트
    yearSelect.addEventListener('change', populateDays);
    monthSelect.addEventListener('change', populateDays);

    // 초기 일 옵션 생성
    populateDays();
});