import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greeting()
    @State private var user: String = "Pending"
    
    var body: some View {
        VStack{
            Button(action: {
                Provider().getUser(
                    completionHandler: { response, error in
                        if let data = response {
                            user = data
                            
                        }
                    }
                )
            }, label: {
                Text(greet)
            })
            Spacer().frame(height: 50)
            Text(user)
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
