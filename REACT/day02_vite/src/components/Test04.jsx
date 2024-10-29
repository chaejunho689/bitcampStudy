import React, { useState } from "react";

const Test04 = () => {
    const [visible, isVisible] = useState(true);

    const onToggle = () => {
        isVisible(!visible);
    }
    const onShow = () => {
        isVisible(true);
    }
    const onHide = () => {
        isVisible(false);
    }
    return (
        <div>
            <button onClick={onShow} >보이기</button>
            <button onClick={onHide} >숨기기</button>
            <button onClick={onToggle}> {visible ? '숨기기' : '보이기'} </button>
            <hr/>
            {
              visible ? <div style={{ width: 300, height: 100, margin: 20, background: 'hotpink'}}></div> : null
            }
            {
              visible && (<div style={{ width: 300, height: 100, margin: 20, background: 'hotpink'}}></div>)
            }
            
        </div>
    );
};

export default Test04;