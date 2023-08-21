// 获取当前年份的元素
var currentYearElement = document.getElementById('current-year');
// 初始年份
var currentYear = 2023;

// 切换年份函数
function changeYear(delta) {
    currentYear += delta;
    currentYearElement.innerText = currentYear;
    // 在此处可以添加获取对应年份的行事历数据的逻辑
}

// 初始化时显示初始年份
currentYearElement.innerText = currentYear;