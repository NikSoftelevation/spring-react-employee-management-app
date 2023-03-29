import "./App.css";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import ListEmployeeComponent from "./components/ListEmployeeComponent";

function App() {
  return (
    <div>
      <HeaderComponent />
      <ListEmployeeComponent />
      <FooterComponent />
    </div>
  );
}

export default App;
