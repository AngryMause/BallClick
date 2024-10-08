import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
init(){
    MainViewControllerKt.doInitSingleComponent()
}
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
