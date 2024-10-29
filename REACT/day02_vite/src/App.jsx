import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Test01 from './components/Test01'
import Test02 from './components/Test02'
import Test03 from './components/Test03'
import Test04 from './components/Test04'
import Test05 from './components/Test05'
import Test06 from './components/Test06'
import Cat from './components/cat/Cat'
import SungJuk from './components/sungJuk/SungJuk'


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        {/* <Test01/>
        <Test02/>
        <Test03/>
        <Test04/>
        <Test05/>
        <Test06/> */}
        {/* <Cat/> */}
        <SungJuk/>
      </div>
    </>
  )
}

export default App
