import React, {useState} from "react";

const Test03 = () => {
    const [name, setName] = useState('홍길동');
    const [age, setAge] = useState(20);
    const [color, setColor] = useState('background : cyan');
    
    const onName = () => {
        setName('코난')
    }

    const onAge = (age) => {
        setAge(age)
    }

    const onColor = () => {
        setColor('yellow')
    }
    return (
        <div>
            <h2 stlye={{background : color }}>
                이름 : {name } / 나이 : {age} 
            </h2>
            <p>
                <button onClick={ onName }>이름을 코난으로 변경 </button>
                <button onClick={ () => onAge(30) }> 나이를 30으로 변경 </button>
                <button onClick={ () => setAge(50) }> 나이를 50으로 변경 </button>
                <button onClick={ onColor }> 노란색으로 변경 </button>
            </p>
        </div>
    );
};
export default Test03;