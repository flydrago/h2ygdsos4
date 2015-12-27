
//存储值
function setItem(key,value){
	
	localStorage.removeItem(key);
	localStorage.setItem(key,value);
}

//移除值
function removeItem(key){
	localStorage.removeItem(key);
}

//获取存储值
function getItem(key){
	return localStorage.getItem(key);
}





